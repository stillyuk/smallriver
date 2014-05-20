package cn.zucc.graduation.web.project;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.zucc.graduation.entity.Discuss;
import cn.zucc.graduation.entity.Project;
import cn.zucc.graduation.entity.ProjectResource;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.project.ProjectResourceService;
import cn.zucc.graduation.service.project.ProjectService;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

@Controller
@RequestMapping("/project")
public class ProjectResourceController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private ProjectResourceService projectResourceService;

	@RequestMapping("listProjectResource")
	public String list(long projectId, Model model) {
		List<ProjectResource> projectResources = projectResourceService.getAllProjectResource(projectId);
		Project project = projectService.getProject(projectId);
		model.addAttribute("projectResources", projectResources);
		model.addAttribute("project", project);
		return "project/projectResourceList";
	}

	@RequestMapping("projectResourceDetail")
	public String groupResourceDetail(long projectResourceId, Model model) {
		ProjectResource projectResource = projectResourceService.getProjectResource(projectResourceId);
		model.addAttribute("projectResource", projectResource);
		return "project/projectResourceDetail";
	}

	@RequestMapping("addDiscuss")
	public String addDiscuss(long projectResourceId, String discuss, RedirectAttributes redirectAttributes) {
		Pattern p = Pattern.compile("：(\\w+)");
		Pattern user = Pattern.compile("@(\\w+)：");
		Matcher m = p.matcher(discuss);
		Matcher u = user.matcher(discuss);
		String content = discuss;
		String replyTo = null;
		while (m.find()) {
			content = m.group(1);
		}
		while (u.find()) {
			replyTo = u.group(1);
		}
		ProjectResource groupResource = projectResourceService.getProjectResource(projectResourceId);
		Discuss dis = new Discuss();
		dis.setContent(content);
		User to = null;
		if (replyTo != null) {
			to = accountService.queryByLoginName(replyTo);
		}
		if (to != null) {
			dis.setReplyTo(to);
		}
		dis.setDate(new Date());
		dis.setUser(new User(ShiroUserUtil.getCurrentUserId()));
		List<Discuss> discusses = groupResource.getDiscusses();
		discusses.add(dis);
		groupResource.setDiscusses(discusses);
		projectResourceService.save(groupResource);
		redirectAttributes.addAttribute("projectResourceId", projectResourceId);
		return "redirect:/project/projectResourceDetail";
	}
}

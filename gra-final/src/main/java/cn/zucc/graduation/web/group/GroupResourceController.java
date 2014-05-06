package cn.zucc.graduation.web.group;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.zucc.graduation.entity.Discuss;
import cn.zucc.graduation.entity.GroupResource;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.group.GroupService;
import cn.zucc.graduation.service.groupresource.GroupResourceService;

@Controller
@RequestMapping("/group")
public class GroupResourceController {

	@Autowired
	private GroupService groupService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private GroupResourceService groupResourceService;

	@RequestMapping("listGroupResource")
	public String list(long groupId, Model model) {
		List<GroupResource> groupResources = groupResourceService.getAllGroupResource(groupId);
		model.addAttribute("groupResources", groupResources);
		return "group/groupResourceList";
	}

	@RequestMapping("groupResourceDetail")
	public String groupResourceDetail(long groupResourceId, Model model) {
		GroupResource groupResource = groupResourceService.getGroupResource(groupResourceId);
		model.addAttribute("groupResource", groupResource);
		return "group/groupResourceDetail";
	}

	@RequestMapping("addDiscuss")
	public String addDiscuss(long groupResourceId, String discuss, RedirectAttributes redirectAttributes) {
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
		GroupResource groupResource = groupResourceService.getGroupResource(groupResourceId);
		Discuss dis = new Discuss();
		dis.setContent(content);
		User to = null;
		if (replyTo != null) {
			to = accountService.queryByLoginName(replyTo);
		}
		if (to != null) {
			dis.setReplyTo(to);
		}
		dis.setDiscussDate(new Date());
		dis.setUser(new User(getCurrentUserId()));
		List<Discuss> discusses = groupResource.getDiscusses();
		discusses.add(dis);
		groupResource.setDiscusses(discusses);
		groupResourceService.save(groupResource);
		redirectAttributes.addAttribute("groupResourceId", groupResourceId);
		return "redirect:/group/groupResourceDetail";
	}

	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getId();
	}
}

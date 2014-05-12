package cn.zucc.graduation.web.project;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.Project;
import cn.zucc.graduation.entity.ProjectResource;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.project.ProjectResourceService;
import cn.zucc.graduation.service.project.ProjectService;
import cn.zucc.graduation.utils.PropUtil;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectResourceService projectResourceService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		Long userId = ShiroUserUtil.getCurrentUserId();
		List<Project> projects = projectService.findProjectsByUserId(userId);
		model.addAttribute("projects", projects);
		return "project/projectList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create() {
		return "project/addProjectForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String doCreate(Project project, Model model) {
		Long userId = ShiroUserUtil.getCurrentUserId();
		User user = new User(userId);
		Group group = new Group();
		group.setManager(user);
		group.setUsers(Arrays.asList(user));
		project.setGroup(group);
		project.setDate(new Date());
		projectService.save(project);
		model.addAttribute("message", "项目" + project.getProjectName() + "创建成功");
		List<Project> projects = projectService.findProjectsByUserId(userId);
		model.addAttribute("projects", projects);
		return "project/projectList";
	}

	@RequestMapping(value = "allProjects")
	public String allProjects(Model model) {
		List<Project> projects = projectService.getAllProjects();
		model.addAttribute("projects", projects);
		return "project/allProjects";
	}

	@RequestMapping(value = "projectDetail")
	public String projectDetail(Long projectId, Model model) {
		Project project = projectService.getProject(projectId);
		List<User> users = project.getGroup().getUsers();
		model.addAttribute("project", project);
		model.addAttribute("projectSize", users.size());
		boolean isMember = projectService.isProjectMemberQueryByUserId(projectId, ShiroUserUtil.getCurrentUserId());
		model.addAttribute("isMember", isMember);
		return "project/projectDetail";
	}

	@RequestMapping(value = "allMembers")
	public String allMembers(Long projectId, Model model) {
		Project project = projectService.getProject(projectId);
		List<User> users = project.getGroup().getUsers();
		model.addAttribute("users", users);
		model.addAttribute("projectSize", users.size());
		return "project/allMembers";
	}

	@RequestMapping(value = "shareResource")
	public String shareResource(Long projectId, Model model) {
		Project project = projectService.getProject(projectId);
		model.addAttribute("project", project);
		return "project/shareResource";
	}

	@RequestMapping(value = "saveResource")
	public String saveResource(Long projectId, MultipartFile file) throws Exception {
		String location = PropUtil.getProperty("projectFile");
		Project project = projectService.getProject(projectId);
		File path = new File(location + project.getProjectName());
		if (!path.exists()) {
			path.mkdirs();
		}
		file.transferTo(new File(location + project.getProjectName() + "/" + file.getOriginalFilename()));
		ProjectResource projectResource = new ProjectResource();
		projectResource.setProject(project);
		projectResource.setName(file.getOriginalFilename());
		projectResource.setDate(new Date());
		projectResource.setLocation(location + project.getProjectName());
		User user = new User();
		user.setId(ShiroUserUtil.getCurrentUserId());
		projectResource.setUploadUser(user);
		projectResourceService.save(projectResource);
		return "project/shareResource";
	}
}

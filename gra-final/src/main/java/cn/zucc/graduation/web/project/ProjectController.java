package cn.zucc.graduation.web.project;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.Project;
import cn.zucc.graduation.entity.ProjectResource;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.group.GroupService;
import cn.zucc.graduation.service.project.ProjectResourceService;
import cn.zucc.graduation.service.project.ProjectService;
import cn.zucc.graduation.utils.PropUtil;
import cn.zucc.graduation.utils.StringUtil;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private GroupService groupService;
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
	public String create(Long groupId, Model model) {
		if (groupId != null) {
			Group group = groupService.getGroup(groupId);
			model.addAttribute("group", group);
		}
		List<Group> ownGroups = groupService.getGroupsByOwnerId(ShiroUserUtil.getCurrentUserId());
		model.addAttribute("ownGroups", ownGroups);
		model.addAttribute("groupSize", ownGroups.size());
		return "project/addProjectForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String doCreate(Project project, String groupName, Model model) {
		Group group = groupService.getGroupByGroupName(groupName);
		project.setGroup(group);
		project.setDate(new Date());
		projectService.save(project);
		model.addAttribute("message", "项目" + project.getProjectName() + "创建成功");
		List<Project> projects = projectService.findProjectsByUserId(ShiroUserUtil.getCurrentUserId());
		model.addAttribute("projects", projects);
		return "project/projectList";
	}

	@RequestMapping(value = "allProjects")
	public String allProjects(Model model) {
		List<Project> projects = projectService.getAllProjects();
		model.addAttribute("projects", projects);
		return "project/allProjects";
	}

	@RequestMapping(value = "getAllProjects")
	@ResponseBody
	public String getAllProjects(String groupName, Model model) throws Exception {
		List<Project> projects = null;
		if (StringUtil.hasLength(groupName)) {
			Group group = groupService.getGroupByGroupName(groupName);
			if (group != null && group.getProjects() != null) {
				projects = group.getProjects();
			}
		} else {
			projects = projectService.getAllProjects();
		}
		OutputStream out = new ByteArrayOutputStream();
		ObjectMapper objectMapper = new ObjectMapper();
		JsonGenerator jsonGenerator = objectMapper.getFactory().createJsonGenerator(out, JsonEncoding.UTF8);
		jsonGenerator.writeObject(projects);
		return out.toString();
	}

	@RequestMapping(value = "projectDetail")
	public String projectDetail(Long projectId, Model model) {
		Project project = projectService.getProject(projectId);
		model.addAttribute("project", project);
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
	@ResponseBody
	public String saveResource(Long projectId, MultipartFile file) throws Exception {
		try {
			String location = PropUtil.getProperty("projectFile");
			Project project = projectService.getProject(projectId);
			File path = new File(location + project.getProjectName());
			if (!path.exists()) {
				path.mkdirs();
			}
			String fileName = file.getOriginalFilename();
			File to = new File(location + project.getProjectName() + File.separator + fileName);
			while (to.exists()) {
				fileName = new SimpleDateFormat("yyyyMMdd_HHmmss_").format(new Date()) + fileName;
				to = new File(location + project.getProjectName() + File.separator + fileName);
			}
			file.transferTo(to);
			ProjectResource projectResource = new ProjectResource();
			projectResource.setProject(project);
			projectResource.setName(file.getOriginalFilename());
			projectResource.setDate(new Date());
			projectResource.setLocation(location + project.getProjectName());
			User user = new User();
			user.setId(ShiroUserUtil.getCurrentUserId());
			projectResource.setUploadUser(user);
			projectResourceService.save(projectResource);
		} catch (Exception e) {
			return "{\"message\" : \"上传资源到项目失败\"}";
		}
		return "{\"message\" : \"上传资源到项目成功\"}";
	}
}

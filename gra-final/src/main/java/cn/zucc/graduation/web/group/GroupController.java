package cn.zucc.graduation.web.group;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
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
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.group.GroupService;
import cn.zucc.graduation.service.groupresource.GroupResourceService;
import cn.zucc.graduation.service.project.ProjectService;
import cn.zucc.graduation.utils.PropUtil;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private GroupService groupService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private GroupResourceService groupResourceService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		Long userId = getCurrentUserId();
		List<Group> groups = groupService.findGroupsByUserId(userId);
		model.addAttribute("groups", groups);
		return "group/groupList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create() {
		return "group/addGroupForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String doCreate(Group group, Model model) {
		Long userId = getCurrentUserId();
		User user = new User();
		user.setId(userId);
		group.setManager(user);
		group.setDate(new Date());
		group.setUsers(Arrays.asList(user));
		groupService.save(group);
		model.addAttribute("message", "群组" + group.getGroupName() + "创建成功");
		List<Group> groups = groupService.findGroupsByUserId(userId);
		model.addAttribute("groups", groups);
		return "group/groupList";
	}

	@RequestMapping(value = "allGroups")
	public String allGroups(Model model) {
		List<Group> groups = groupService.getAllGroups();
		model.addAttribute("groups", groups);
		return "group/allGroups";
	}

	@RequestMapping(value = "groupDetail")
	public String groupDetail(Long groupId, Model model) {
		Group group = groupService.getGroup(groupId);
		List<User> users = group.getUsers();
		model.addAttribute("group", group);
		model.addAttribute("groupSize", users.size());
		boolean isMember = groupService.isGroupMemberQueryByUserId(groupId, ShiroUserUtil.getCurrentUserId());
		model.addAttribute("isMember", isMember);
		return "group/groupDetail";
	}

	@RequestMapping(value = "allMembers")
	public String allMembers(Long groupId, Model model) {
		Group group = groupService.getGroup(groupId);
		List<User> users = group.getUsers();
		model.addAttribute("users", users);
		model.addAttribute("groupSize", users.size());
		return "group/allMembers";
	}

	@RequestMapping(value = "shareResource")
	public String shareResource(Long groupId, Model model) {
		Group group = groupService.getGroup(groupId);
		model.addAttribute("group", group);
		return "group/shareResource";
	}

	@RequestMapping(value = "saveResource")
	public String saveResource(Long projectId, MultipartFile file) throws Exception {
		String location = PropUtil.getProperty("groupFile");
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
		user.setId(getCurrentUserId());
		projectResource.setUploadUser(user);
		groupResourceService.save(projectResource);
		return "group/shareResource";
	}

	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getId();
	}
}

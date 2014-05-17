package cn.zucc.graduation.web.group;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.Project;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.group.GroupService;
import cn.zucc.graduation.service.groupresource.GroupResourceService;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private GroupService groupService;
	@Autowired
	private GroupResourceService groupResourceService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		Long userId = ShiroUserUtil.getCurrentUserId();
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
		Long userId = ShiroUserUtil.getCurrentUserId();
		User user = new User();
		user.setId(userId);
		group.setManager(user);
		group.setDate(new Date());
		group.setUsers(Arrays.asList(user));
		groupService.save(group);
		model.addAttribute("message", "团队" + group.getGroupName() + "创建成功");
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
		model.addAttribute("projectSize", group.getProjects().size());
		boolean isMember = groupService.isGroupMemberQueryByUserId(groupId, ShiroUserUtil.getCurrentUserId());
		model.addAttribute("isMember", isMember);
		return "group/groupDetail";
	}

	@RequestMapping(value = "allProjects")
	public String allProjects(Long groupId, Model model) {
		Group group = groupService.getGroup(groupId);
		List<Project> projects = group.getProjects();
		model.addAttribute("projects", projects);
		model.addAttribute("projectSize", projects.size());
		return "group/allProjects";
	}

	@RequestMapping(value = "allMembers")
	public String allMembers(Long groupId, Model model) {
		Group group = groupService.getGroup(groupId);
		List<User> users = group.getUsers();
		model.addAttribute("users", users);
		model.addAttribute("userSize", users.size());
		return "group/allMembers";
	}

	@RequestMapping(value = "shareResource")
	public String shareResource(Long groupId, Model model) {
		Group group = groupService.getGroup(groupId);
		model.addAttribute("group", group);
		return "group/shareResource";
	}
}

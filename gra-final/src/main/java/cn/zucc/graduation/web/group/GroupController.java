package cn.zucc.graduation.web.group;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.group.GroupService;

@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private GroupService groupService;

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
		group.setCreateDate(new Date());
		group.setUsers(Arrays.asList(user));
		groupService.save(group);
		model.addAttribute("message", "组" + group.getGroupName() + "创建成功");
		return "group/groupList";
	}

	@RequestMapping(value = "allGroups", method = RequestMethod.GET)
	public String allGroups(Model model) {
		List<Group> groups = groupService.getAllGroups();
		model.addAttribute("groups", groups);
		return "group/allGroups";
	}

	@RequestMapping(value = "groupDetail", method = RequestMethod.GET)
	public String groupDetail(Long groupId, Model model) {
		Group group = groupService.getGroup(groupId);
		List<User> users = group.getUsers();
		model.addAttribute("group", group);
		model.addAttribute("groupSize", users.size());
		return "group/groupDetail";
	}

	@RequestMapping(value = "allMembers", method = RequestMethod.GET)
	public String allMembers(Long groupId, Model model) {
		Group group = groupService.getGroup(groupId);
		List<User> users = group.getUsers();
		model.addAttribute("users", users);
		model.addAttribute("groupSize", users.size());
		return "group/allMembers";
	}

	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getId();
	}
}
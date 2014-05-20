package cn.zucc.graduation.web.index;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.Message;
import cn.zucc.graduation.entity.Project;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.group.GroupService;
import cn.zucc.graduation.service.message.MessageService;
import cn.zucc.graduation.service.project.ProjectService;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

@Controller
public class IndexController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private GroupService groupService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping("index")
	public String index(Model model) {
		List<Message> messages = messageService.findMessagesByReceiveIdAndUnRead(ShiroUserUtil.getCurrentUserId());
		model.addAttribute("messages", messages);
		model.addAttribute("size", messages.size());
		return "home";
	}

	@RequestMapping("search")
	public String search(String content, String searchGroupName, String searchProjectName, Model model) {
		List<User> users = null;
		List<Group> groups = null;
		if (searchGroupName.equals("") && searchProjectName.equals("")) {
			users = accountService.search(content.trim());
			groups = groupService.search(content.trim());
		} else if (!searchGroupName.equals("")) {
			Group group = groupService.getGroupByGroupName(searchGroupName);
			users = new ArrayList<User>();
			for (User user : group.getUsers()) {
				Pattern p = Pattern.compile(".*" + content + ".*");
				Matcher m = p.matcher(user.getLoginName());
				if (m.find()) {
					users.add(user);
				} else {
					m = p.matcher(user.getName());
					if (m.find()) {
						users.add(user);
					}
				}
			}
		} else if (!searchProjectName.equals("")) {
			Project project = projectService.getProjectByProjectName(searchProjectName);
			Group group = project.getGroup();
			users = new ArrayList<User>();
			for (User user : group.getUsers()) {
				Pattern p = Pattern.compile(".*" + content + ".*");
				Matcher m = p.matcher(user.getLoginName());
				if (m.find()) {
					users.add(user);
				} else {
					m = p.matcher(user.getName());
					if (m.find()) {
						users.add(user);
					}
				}
			}
		}
		model.addAttribute("content", content);
		model.addAttribute("users", users);
		model.addAttribute("groups", groups);
		return "search";
	}
}

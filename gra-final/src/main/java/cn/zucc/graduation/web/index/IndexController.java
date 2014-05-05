package cn.zucc.graduation.web.index;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.Message;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.group.GroupService;
import cn.zucc.graduation.service.message.MessageService;

@Controller
public class IndexController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private GroupService groupService;

	@RequestMapping("index")
	public String index(Model model) {
		List<Message> messages = messageService.findMessagesByReceiveIdAndUnRead(getCurrentUserId());
		model.addAttribute("messages", messages);
		model.addAttribute("size", messages.size());
		return "home";
	}

	@RequestMapping("search")
	public String search(String content, Model model) {
		model.addAttribute("content", content);
		List<User> users = accountService.search(content.trim());
		List<Group> groups = groupService.search(content.trim());
		model.addAttribute("users", users);
		model.addAttribute("groups", groups);
		return "search";
	}

	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		if (user != null) {
			return user.getId();
		}
		return -1L;
	}
}

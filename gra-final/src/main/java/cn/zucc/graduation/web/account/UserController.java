package cn.zucc.graduation.web.account;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.zucc.graduation.core.MessageType;
import cn.zucc.graduation.entity.Message;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.friend.FriendService;
import cn.zucc.graduation.service.message.MessageService;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

/**
 * @author jiangyukun
 * @since 2014-05-03
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private AccountService accountService;

	@Autowired
	private FriendService friendService;

	@Autowired
	private MessageService messageService;

	@RequestMapping("info")
	public String userInfo(@RequestParam("userId") Long userId, Model model) {
		User user = accountService.getUser(userId);
		Boolean isFriend = friendService.isFriendQuerybyFromAndTo(ShiroUserUtil.getCurrentUserId(), userId);
		model.addAttribute("user", user);
		model.addAttribute("isFriend", isFriend);
		return "account/userInfo";
	}

	@RequestMapping("add")
	public String add(Long toId, Model model) {
		Long userId = ShiroUserUtil.getCurrentUserId();
		User user = accountService.getUser(userId);
		Boolean isFriend = friendService.isFriendQuerybyFromAndTo(userId, toId);
		Message message = new Message();
		message.setContent(user.getLoginName() + "请求添加您为好友");
		message.setFrom(user);
		User to = accountService.getUser(toId);
		message.setTo(to);
		message.setDate(new Date());
		message.setMessageFromType(MessageType.SYSTEM);
		message.setMessageToType(MessageType.ADD_FRIEND);
		messageService.save(message);
		model.addAttribute("user", to);
		model.addAttribute("isFriend", isFriend);
		model.addAttribute("message", "请求已发送");
		return "account/userInfo";
	}
}

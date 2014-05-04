package cn.zucc.graduation.web.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zucc.graduation.entity.Friend;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.friend.FriendService;
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

	@RequestMapping("info")
	public String userInfo(Long userId, Model model) {
		User user = accountService.getUser(userId);
		Boolean isFriend = friendService.isFriendQuerybyFromAndTo(ShiroUserUtil.getCurrentUserId(), userId);
		model.addAttribute("user", user);
		model.addAttribute("isFriend", isFriend);
		return "account/userInfo";
	}

	@RequestMapping("add")
	public String add(Long toId, Model model) {
		Long userId = ShiroUserUtil.getCurrentUserId();
		User from = new User(userId);
		User to = new User(toId);
		Friend friend = new Friend();
		friend.setFrom(from);
		friend.setTo(to);
		friendService.save(friend);
		model.addAttribute("message", "ok");
		return "account/userInfo";
	}
}

package cn.zucc.graduation.web.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zucc.graduation.entity.Friend;
import cn.zucc.graduation.entity.Message;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.friend.FriendService;
import cn.zucc.graduation.service.message.MessageService;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

/**
 * @author jiangyukun
 * @since 2014-05-05
 */
@Controller
@RequestMapping("/friend")
public class FriendController {
	@Autowired
	private FriendService friendService;
	@Autowired
	private MessageService messageService;

	@RequestMapping("/handler")
	public String handlerRequest(Long toId, String choice, Long messageId) {
		if (choice.equals("yes")) {
			Long userId = ShiroUserUtil.getCurrentUserId();
			User from = new User(userId);
			User to = new User(toId);
			Friend friend = new Friend();
			friend.setFrom(from);
			friend.setTo(to);
			friendService.save(friend);
		}
		Message message = messageService.getMessage(messageId);
		message.setIsRead(true);
		messageService.save(message);
		return "";
	}
}

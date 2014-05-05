package cn.zucc.graduation.web.message;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zucc.graduation.entity.Friend;
import cn.zucc.graduation.entity.Message;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.friend.FriendService;
import cn.zucc.graduation.service.message.MessageService;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private FriendService friendService;
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "sendMessage", method = RequestMethod.GET)
	public String sendMessage(Model model) {
		List<Friend> friends = friendService.findFriendsByUserId(ShiroUserUtil.getCurrentUserId());
		model.addAttribute("friends", friends);
		return "message/sendMessage";
	}

	@RequestMapping(value = "doSendMessage", method = RequestMethod.POST)
	public String doSendMessage(String message, String toUser, Model model) {
		Message msg = new Message();
		msg.setContent(message);
		msg.setFrom(new User(ShiroUserUtil.getCurrentUserId()));
		msg.setTo(new User(accountService.queryByLoginName(toUser).getId()));
		msg.setMessageDate(new Date());
		messageService.save(msg);
		List<Friend> friends = friendService.findFriendsByUserId(ShiroUserUtil.getCurrentUserId());
		model.addAttribute("message", "发送成功");
		model.addAttribute("friends", friends);
		return "message/sendMessage";
	}

	@RequestMapping(value = "updateState", method = RequestMethod.GET)
	public String updateState(Long messageId) {
		Message message = messageService.getMessage(messageId);
		message.setIsRead(true);
		messageService.update(message);
		return "home";
	}

	@RequestMapping(value = "allReceiveMessages", method = RequestMethod.GET)
	public String allReceiveMessages(Model model) {
		List<Message> messages = messageService.getMessagesByReceiveId(ShiroUserUtil.getCurrentUserId());
		model.addAttribute("messages", messages);
		return "message/allReceiveMessage";
	}

	@RequestMapping(value = "allSendMessages", method = RequestMethod.GET)
	public String allSendMessages(Model model) {
		List<Message> messages = messageService.getMessagesBySendId(ShiroUserUtil.getCurrentUserId());
		model.addAttribute("messages", messages);
		return "message/allSendMessage";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long messageId, Model model) {
		Message message = messageService.getMessage(messageId);
		model.addAttribute("message", message);
		return "message/messageDetail";
	}

}

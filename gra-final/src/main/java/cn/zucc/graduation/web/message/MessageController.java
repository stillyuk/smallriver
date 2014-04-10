package cn.zucc.graduation.web.message;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zucc.graduation.entity.Message;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.message.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "sendMessage", method = RequestMethod.GET)
	public String send() {
		return "message/sendMessage";
	}
	
	@RequestMapping(value = "updateState", method = RequestMethod.GET)
	public String updateState(Long messageId) {
		Message message = messageService.getMessage(messageId);
		message.setIsRead(true);
		messageService.update(message);
		return "/index";
	}

	@RequestMapping(value = "allReceiveMessages", method = RequestMethod.GET)
	public String allReceiveMessages(Model model) {
		List<Message> messages = messageService.getMessagesByReceiveId(getCurrentUserId());
		model.addAttribute("messages", messages);
		return "message/allMessage";
	}

	@RequestMapping(value = "allSendMessages", method = RequestMethod.GET)
	public String allSendMessages(Model model) {
		List<Message> messages = messageService.getMessagesBySendId(getCurrentUserId());
		model.addAttribute("messages", messages);
		return "message/allMessage";
	}

	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getId();
	}
}

package cn.zucc.graduation.web.index;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zucc.graduation.entity.Message;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.message.MessageService;

@Controller("/")
public class IndexController {

	@Autowired
	private MessageService messageService;

	@RequestMapping("index")
	public String index(Model model) {
		List<Message> messages = messageService.findMessagesByReceiveIdAndUnRead(getCurrentUserId());
		model.addAttribute("messages", messages);
		return "home";
	}

	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		if (user != null) {
			return user.getId();
		}
		return -1L;
	}
}

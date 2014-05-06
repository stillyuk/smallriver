package cn.zucc.graduation.web.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.AccountService;

@Controller
@RequestMapping("/activate")
public class ActivateController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String activate(Long userId, String activateCode, RedirectAttributes redirectAttributes) {
		User user = accountService.getUser(userId);
		user.setIsActivate(true);
		accountService.save(user);
		redirectAttributes.addFlashAttribute("username", user.getLoginName());
		return "redirect:/login";
	}
}

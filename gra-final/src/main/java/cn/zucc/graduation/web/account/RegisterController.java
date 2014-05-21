package cn.zucc.graduation.web.account;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.entity.UserDetailInfo;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.utils.JavaMailUtil;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String registeForm() {
		return "account/register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registe(User user, RedirectAttributes redirectAttributes) {
		user.setActivateCode(UUID.randomUUID().toString());
		user.setPassword(new Md5Hash(user.getPassword()).toHex());
		user.setDate(new Date());
		user.setRoles("user");
		UserDetailInfo userDetailInfo = new UserDetailInfo();
		userDetailInfo.setLoginDays(0);
		userDetailInfo.setUserLevel(0);
		user.setUserDetailInfo(userDetailInfo);
		accountService.save(user);
		final User u = user;
		new Thread((new Runnable() {
			public void run() {
				JavaMailUtil.sendMail("191295604@qq.com", u);
			}
		})).start();
		String mailServer = null;
		Pattern p = Pattern.compile("@(.*)");
		Matcher m = p.matcher(user.getEmail());
		while (m.find()) {
			mailServer = "http://mail." + m.group(1);
		}
		redirectAttributes.addFlashAttribute("mailServer", mailServer);
		redirectAttributes.addFlashAttribute("user", user);
		return "redirect:/activate/page";
	}

	@RequestMapping(value = "checkLoginName")
	@ResponseBody
	public String checkLoginName(@RequestParam("loginName") String loginName) {
		if (accountService.findUserByLoginName(loginName) == null) {
			return "true";
		} else {
			return "false";
		}
	}
}

package cn.zucc.graduation.utils;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import cn.zucc.graduation.entity.User;

/**
 * @author jiangyukun
 * @since 2014-05-05
 */
public class JavaMailUtil {
	private static JavaMailSender sender;

	public static void sendMail(String to, User user) {
		MimeMessage mailMessage = sender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, "UTF-8");
			messageHelper.setFrom("191295604@qq.com");
			messageHelper.setTo(to);
			messageHelper.setSubject("请确认你的注册邮箱");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", user.getId());
			map.put("loginName", user.getLoginName());
			map.put("url", "http://localhost/gra/activate?userId=" + user.getId() + "&activateCode=" + user.getActivateCode());
			messageHelper.setText(FreemarkerUtil.process(map), true);
			sender.send(mailMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setSender(JavaMailSender sender) {
		JavaMailUtil.sender = sender;
	}

}

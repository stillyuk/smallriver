package cn.zucc.graduation.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * @author jiangyukun
 * @since 2014-05-05
 */
public class JavaMailUtil {
	private static JavaMailSender sender;

	public static void sendMail(String to) {
		SimpleMailMessage mail = new SimpleMailMessage();
		try {
			mail.setTo(to);
			mail.setFrom("x31001333@163.com");
			mail.setSubject("spring mail test!");
			mail.setText("springMail的简单发送测试");
			sender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static JavaMailSender getSender() {
		return sender;
	}

	public static void setSender(JavaMailSender sender) {
		JavaMailUtil.sender = sender;
	}
	
}

package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml", "classpath:applicationContext-mail.xml" })
public class MailTest {

	@Autowired
	private JavaMailSender sender;

	@Test
	public void sender() {
		String to = "191295604@qq.com";
		SimpleMailMessage mail = new SimpleMailMessage();
		try {
			mail.setTo(to);
			mail.setFrom("191295604@qq.com");
			mail.setSubject("spring mail test!");
			mail.setText("springMail的简单发送测试");
			sender.send(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

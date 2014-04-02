package graduation.webspring;

import graduation.test.Test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author orange
 * @since 2014-03-30
 * just for test
 */
@Controller
@RequestMapping("test")
public class TestController {
	@RequestMapping("test")
	public ModelAndView test() {
		return new ModelAndView("/test/test", "a", new Test());
	}
}

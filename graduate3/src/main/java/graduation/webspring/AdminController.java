package graduation.webspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author jiangyukun
 * @since 2014-03-21 17:59
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping({ "/", "index" })
	public ModelAndView index() {
		return new ModelAndView("admin/index");
	}

	@RequestMapping("userManage")
	public ModelAndView userManage() {
		return new ModelAndView("admin/userManage");
	}
}

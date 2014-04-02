package graduation.webspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jiangyukun
 * @since 2014-03-19 17:53
 */
@Controller
@RequestMapping("/system")
public class SystemController {

	@RequestMapping({ "/", "index" })
	public String index() {
		return "admin/index";
	}
}

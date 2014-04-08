package cn.zucc.graduation.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/test")
public class TestController {

	@RequestMapping("test")
	public String test() {
		return "test/test";
	}
}

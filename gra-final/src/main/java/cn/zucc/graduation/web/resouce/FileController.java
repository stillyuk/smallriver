package cn.zucc.graduation.web.resouce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.resource.ResourceService;

@Controller
@RequestMapping("/file")
public class FileController {

	@Autowired
	private ResourceService resouceService;
	@Autowired
	private AccountService accountService;

	@RequestMapping("delete")
	public String delete(Long resourceId, Model model) {
		resouceService.delete(resourceId);
		return "file/fileUpload";
	}
}

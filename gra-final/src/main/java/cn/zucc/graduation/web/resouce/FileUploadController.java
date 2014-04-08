package cn.zucc.graduation.web.resouce;

import java.io.File;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.zucc.graduation.entity.Resource;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.resource.ResouceService;
import cn.zucc.graduation.utils.PropUtil;

@Controller
@RequestMapping("/file/upload")
public class FileUploadController {

	@Autowired
	private ResouceService resouceService;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "file/fileUpload";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String upload(MultipartFile file) throws Exception {
		String location = PropUtil.getProperty("file");
		File path = new File(location + getCurrentUserLoginName());
		if (!path.exists()) {
			path.mkdirs();
			file.transferTo(new File(location + getCurrentUserLoginName() + "/" + file.getOriginalFilename()));
		}
		Resource resource = new Resource();
		resource.setName(file.getOriginalFilename());
		resource.setLocation(location + getCurrentUserLoginName());
		resource.setDate(new Date());
		resouceService.saveResource(resource);
		return "redirect:/file/upload";
	}

	private String getCurrentUserLoginName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getLoginName();
	}
}

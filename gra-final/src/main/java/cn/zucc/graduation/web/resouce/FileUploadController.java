package cn.zucc.graduation.web.resouce;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.zucc.graduation.entity.Resource;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.resource.ResouceService;
import cn.zucc.graduation.utils.PropUtil;

@Controller
@RequestMapping("/file/upload")
public class FileUploadController {

	@Autowired
	private ResouceService resouceService;
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		Long userId = getCurrentUserId();
		List<Resource> resources = resouceService.getResourceByUserId(userId);
		model.addAttribute("total", resources.size());
		return "file/fileUpload";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String upload(MultipartFile file, Model model) throws Exception {
		String location = PropUtil.getProperty("file");
		File path = new File(location + getCurrentUserLoginName());
		if (!path.exists()) {
			path.mkdirs();
		}
		String fileName = file.getOriginalFilename();
		File to = new File(location + getCurrentUserLoginName() + "/" + fileName);
		while (to.exists()) {
			fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + fileName;
			to = new File(location + getCurrentUserLoginName() + "/" + fileName);
		}
		file.transferTo(to);
		Resource resource = new Resource();
		resource.setName(fileName);
		resource.setLocation(location + getCurrentUserLoginName());
		resource.setDate(new Date());
		resource.setUser(accountService.getUser(getCurrentUserId()));
		resource.setFileSize(file.getSize());
		resouceService.saveResource(resource);
		model.addAttribute("message", "上传成功");
		return "file/fileUpload";
	}

	private String getCurrentUserLoginName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getLoginName();
	}

	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getId();
	}
}

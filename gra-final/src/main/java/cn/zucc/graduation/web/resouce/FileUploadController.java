package cn.zucc.graduation.web.resouce;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.zucc.graduation.entity.Resource;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.acount.AccountService;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.resource.ResourceService;
import cn.zucc.graduation.utils.PropUtil;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

@Controller
@RequestMapping("/file/upload")
public class FileUploadController {

	@Autowired
	private ResourceService resouceService;
	@Autowired
	private AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		Long userId = ShiroUserUtil.getCurrentUserId();
		User user = accountService.getUser(userId);
		List<Resource> resources = resouceService.getResourceByUserId(userId);
		long usedSpace = 0;
		for (Resource resource : resources) {
			usedSpace += resource.getFileSize();
		}
		model.addAttribute("total", resources.size());
		model.addAttribute("usedSpace", new BigDecimal(usedSpace * 1.0 / 1024 / 1024).setScale(2, BigDecimal.ROUND_HALF_UP));
		model.addAttribute("diskSpace", (user.getUserDetailInfo().getUserLevel() + 1) * 20);
		return "file/fileUpload";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String upload(MultipartFile file, Model model) throws Exception {
		List<Resource> resources = resouceService.getResourceByUserId(ShiroUserUtil.getCurrentUserId());
		User user = accountService.getUser(ShiroUserUtil.getCurrentUserId());
		long usedSpace = 0;
		for (Resource resource : resources) {
			usedSpace += resource.getFileSize();
		}
		if (usedSpace + file.getSize() > (user.getUserDetailInfo().getUserLevel() + 1) * 20 * 1024 *1024) {
//			model.addAttribute("message", "已达到容量上限，请提高用户等级或删除文件");
			return "{\"message\" : \"已达到容量上限，请提高用户等级或删除已上传文件\"}";
		}
		String location = PropUtil.getProperty("file");
		File path = new File(location + getCurrentUserLoginName());
		if (!path.exists()) {
			path.mkdirs();
		}
		String fileName = file.getOriginalFilename();
		File to = new File(location + getCurrentUserLoginName() + "/" + fileName);
		while (to.exists()) {
			fileName = new SimpleDateFormat("yyyyMMdd_HHmmss_").format(new Date()) + fileName;
			to = new File(location + getCurrentUserLoginName() + "/" + fileName);
		}
		file.transferTo(to);
		Resource resource = new Resource();
		resource.setName(fileName);
		resource.setLocation(location + getCurrentUserLoginName());
		resource.setDate(new Date());
		resource.setUser(accountService.getUser(ShiroUserUtil.getCurrentUserId()));
		resource.setFileSize(file.getSize());
		resouceService.saveResource(resource);
		return "{\"message\" : \"上传成功\"}";
	}

	private String getCurrentUserLoginName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getLoginName();
	}
}

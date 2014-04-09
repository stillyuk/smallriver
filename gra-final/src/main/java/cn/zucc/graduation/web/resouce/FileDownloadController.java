package cn.zucc.graduation.web.resouce;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zucc.graduation.entity.Resource;
import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;
import cn.zucc.graduation.service.resource.ResouceService;

@Controller
@RequestMapping("/file/download")
public class FileDownloadController {

	@Autowired
	private ResouceService resouceService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		Long userId = getCurrentUserId();
		List<Resource> resources = resouceService.getResourceByUserId(userId);
		model.addAttribute("resources", resources);
		return "file/fileDownload";
	}

	@RequestMapping(value = "detail")
	public String downloadForm(Long resourceId, Model model) {
		Long userId = getCurrentUserId();
		Resource resource = resouceService.getResourceByResourceIdAndUserId(userId, resourceId);
		model.addAttribute("resource", resource);
		return "file/fileDownloadDetail";
	}

	@RequestMapping(value = "{resouceId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> download(@PathVariable("resouceId") Long resourceId) throws Exception {
		Resource resource = resouceService.getResource(resourceId);
		resource.setDownloadTimes(resource.getDownloadTimes() + 1);
		resouceService.saveResource(resource);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", resource.getName());
		String filePath = resource.getLocation() + "/" + resource.getName();
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filePath)), headers, HttpStatus.CREATED);
	}

	private Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getId();
	}

	private String getCurrentUserLoginName() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getLoginName();
	}
}

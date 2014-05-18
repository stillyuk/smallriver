package cn.zucc.graduation.web.resouce;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
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

import cn.zucc.graduation.entity.Project;
import cn.zucc.graduation.entity.ProjectResource;
import cn.zucc.graduation.entity.Resource;
import cn.zucc.graduation.service.project.ProjectResourceService;
import cn.zucc.graduation.service.project.ProjectService;
import cn.zucc.graduation.service.resource.ResourceService;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

@Controller
@RequestMapping("/file/download")
public class FileDownloadController {

	@Autowired
	private ResourceService resouceService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectResourceService projectResourceService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		Long userId = ShiroUserUtil.getCurrentUserId();
		List<Resource> resources = resouceService.getResourceByUserId(userId);
		model.addAttribute("resources", resources);
		model.addAttribute("size", resources.size());
		return "file/fileDownload";
	}

	@RequestMapping(value = "/detail")
	public String resourceDetail(Long resourceId, Model model) {
		Long userId = ShiroUserUtil.getCurrentUserId();
		Resource resource = resouceService.getResourceByResourceIdAndUserId(userId, resourceId);
		List<Project> projects = projectService.findProjectsByUserId(userId);
		model.addAttribute("projects", projects);
		model.addAttribute("resource", resource);
		return "file/fileDownloadDetail";
	}

	@RequestMapping(value = "/{resouceId}")
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

	@RequestMapping(value = "/projectResource/{projectResourceId}")
	public ResponseEntity<byte[]> downloadProjectResource(@PathVariable("groupResourceId") Long projectResourceId) throws Exception {
		ProjectResource projectResource = projectResourceService.getProjectResource(projectResourceId);
		projectResource.setDownloadTimes(projectResource.getDownloadTimes() + 1);
		projectResourceService.save(projectResource);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", projectResource.getName());
		String filePath = projectResource.getLocation() + "/" + projectResource.getName();
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filePath)), headers, HttpStatus.CREATED);
	}
}

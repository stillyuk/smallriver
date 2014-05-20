package cn.zucc.graduation.web.resouce;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zucc.graduation.entity.Project;
import cn.zucc.graduation.entity.ProjectResource;
import cn.zucc.graduation.entity.Resource;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.service.project.ProjectResourceService;
import cn.zucc.graduation.service.project.ProjectService;
import cn.zucc.graduation.service.resource.ResourceService;
import cn.zucc.graduation.web.shiro.ShiroUserUtil;

/**
 * @author jiangyukun
 * @since 2014-05-18
 */
@RestController
@RequestMapping("/resource/")
public class ResourceShareController {

	@Autowired
	private ResourceService resourceService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectResourceService projectResourceService;

	@RequestMapping("/share/{resourceId}")
	public String shareResource(@PathVariable("resourceId") Long resourceId, String projectName) {
		try {
			Resource resource = resourceService.getResource(resourceId);
			Project project = projectService.getProjectByProjectName(projectName);
			ProjectResource projectResource = new ProjectResource();
			projectResource.setDate(new Date());
			projectResource.setProject(project);
			projectResource.setLocation(resource.getLocation());
			projectResource.setName(resource.getName());
			projectResource.setUploadUser(new User(ShiroUserUtil.getCurrentUserId()));
			projectResourceService.save(projectResource);
		} catch (Throwable e) {
			System.out.println(e);
			return "{\"message\" : \"共享失败\"}";
		}

		return "{\"message\" : \"共享成功\"}";
	}
}

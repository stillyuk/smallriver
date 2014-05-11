package cn.zucc.graduation.service.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zucc.graduation.entity.ProjectResource;
import cn.zucc.graduation.repository.ProjectResourceDao;

/**
 * @author jiangyukun
 * @since 2014-05-11
 */
public class ProjectResourceService {
	@Autowired
	private ProjectResourceDao ProjectResourceDao;

	public List<ProjectService> getAllProjectResource(long projectId) {
		List<Long> ids = new ArrayList<Long>();
		ids.add(projectId);
		ProjectResourceDao.findAll(ids);
		return null;
	}

	public ProjectResource getProjectResource(long projectResourceId) {
		return ProjectResourceDao.findOne(projectResourceId);
	}

	public void save(ProjectResource projectResource) {
		ProjectResourceDao.save(projectResource);
	}

}

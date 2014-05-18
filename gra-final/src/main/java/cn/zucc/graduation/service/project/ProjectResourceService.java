package cn.zucc.graduation.service.project;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zucc.graduation.entity.ProjectResource;
import cn.zucc.graduation.repository.ProjectResourceDao;

/**
 * @author jiangyukun
 * @since 2014-05-11
 */
@Service
@Transactional
public class ProjectResourceService {
	@Autowired
	private ProjectResourceDao projectResourceDao;

	public List<ProjectResource> getAllProjectResource(long projectId) {
		List<Long> ids = new ArrayList<Long>();
		ids.add(projectId);
		List<ProjectResource> projectResources = (List<ProjectResource>) projectResourceDao.findAll(ids);
		return projectResources;
	}

	public ProjectResource getProjectResource(long projectResourceId) {
		return projectResourceDao.findOne(projectResourceId);
	}

	public void save(ProjectResource projectResource) {
		projectResourceDao.save(projectResource);
	}

}

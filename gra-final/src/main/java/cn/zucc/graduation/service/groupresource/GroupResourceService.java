package cn.zucc.graduation.service.groupresource;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zucc.graduation.entity.ProjectResource;
import cn.zucc.graduation.repository.ProjectResourceDao;

@Service
@Transactional
public class GroupResourceService {

	@Autowired
	private ProjectResourceDao projectResourceDao;

	public ProjectResource save(ProjectResource groupResource) {
		return projectResourceDao.save(groupResource);
	}

	public List<ProjectResource> getAllGroupResource(Long groupId) {
		return projectResourceDao.findGroupResourceByGroupId(groupId);
	}

	public ProjectResource getGroupResource(long groupResourceId) {
		return projectResourceDao.findOne(groupResourceId);
	}
}

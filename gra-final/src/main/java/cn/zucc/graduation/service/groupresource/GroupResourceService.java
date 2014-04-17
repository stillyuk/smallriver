package cn.zucc.graduation.service.groupresource;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zucc.graduation.entity.GroupResource;
import cn.zucc.graduation.repository.GroupResourceDao;

@Service
@Transactional
public class GroupResourceService {

	@Autowired
	private GroupResourceDao groupResourceDao;

	public GroupResource save(GroupResource groupResource) {
		return groupResourceDao.save(groupResource);
	}

	public List<cn.zucc.graduation.entity.GroupResource> getAllGroupResource(Long groupId) {
		return groupResourceDao.findGroupResourceByGroupId(groupId);
	}

	public GroupResource getGroupResource(long groupResourceId) {
		return groupResourceDao.findOne(groupResourceId);
	}
}

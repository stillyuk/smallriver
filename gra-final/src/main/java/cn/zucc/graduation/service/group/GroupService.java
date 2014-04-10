package cn.zucc.graduation.service.group;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.repository.GroupDao;

@Service
@Transactional
public class GroupService {
	@Autowired
	private GroupDao groupDao;

	public Group save(Group group) {
		return groupDao.save(group);
	}

	public void deleteGroup(Long id) {
		groupDao.delete(id);
	}

	public List<User> findUsersByGroupId(Long groupId) {
		return groupDao.findUsersByGroupId(groupId);
	}

	public List<Group> findGroupsByUserId(Long userId) {
		// TODO Auto-generated method stub
		return groupDao.findGroupsByUserId(userId);
	}
}

package cn.zucc.graduation.service.group;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
		return groupDao.findGroupsByUserId(userId);
	}

	public Group getGroup(Long groupId) {
		return groupDao.findOne(groupId);
	}

	public List<Group> getAllGroups() {
		return (List<Group>) groupDao.findAll();
	}

	public Group findManagerByGroupId(Long groupId) {
		return groupDao.findOne(groupId);
	}

	protected Specification<Group> buildSpecification(final String name) {
		Specification<Group> spec = new Specification<Group>() {
			public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(cb.like(root.<String> get("groupName"), "%" + name + "%"));
				return query.getGroupRestriction();
			}
		};
		return spec;
	}

	public List<Group> search(String group) {
		Specification<Group> spec = buildSpecification(group);
		List<Group> groups = groupDao.findAll(spec);
		return groups;
	}

	public boolean isGroupMemberQueryByUserId(Long groupId, Long currentUserId) {
		List<Group> groups = groupDao.isGroupMemberQueryByUserId(groupId, currentUserId);
		if (groups == null || groups.size() == 0) {
			return false;
		}
		return true;
	}

	public Group getGroupByGroupName(String groupName) {
		List<Group> groups = groupDao.getGroupByGroupName(groupName);
		if (groups != null && groups.size() > 0) {
			return groups.get(0);
		}
		return null;
	}
}

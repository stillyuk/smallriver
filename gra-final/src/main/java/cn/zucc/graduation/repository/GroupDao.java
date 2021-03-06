package cn.zucc.graduation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.ProjectResource;
import cn.zucc.graduation.entity.User;

public interface GroupDao extends PagingAndSortingRepository<Group, Long>, JpaSpecificationExecutor<Group> {

	public List<Group> getGroupByGroupName(String groupName);

	@Modifying
	@Query("select u from User u left join u.groups g where g.id=?1")
	public List<User> findUsersByGroupId(Long groupId);

	public List<ProjectResource> findGroupResourceById(Long groupId);

	@Modifying
	@Query("select g from Group g join fetch g.users u where u.id=?1")
	public List<Group> findGroupsByUserId(Long userId);

	@Modifying
	@Query("select g from Group g join fetch g.users u where g.id=?1 and u.id=?2")
	public List<Group> isGroupMemberQueryByUserId(Long groupId, Long currentUserId);

	@Modifying
	@Query("select g from Group g join fetch g.manager m where m.id=?1")
	public List<Group> getGroupsByOwnerId(Long managerId);
}
package cn.zucc.graduation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.User;

public interface GroupDao extends PagingAndSortingRepository<Group, Long>, JpaSpecificationExecutor<Group> {

	@Modifying
	@Query("from User u left join u.groups g where g.id=?1")
	public List<User> findUsersByGroupId(Long groupId);
}
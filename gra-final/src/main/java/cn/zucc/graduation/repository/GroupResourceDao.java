package cn.zucc.graduation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.GroupResource;

public interface GroupResourceDao extends PagingAndSortingRepository<GroupResource, Long>, JpaSpecificationExecutor<GroupResource> {

	@Query("")
	List<GroupResource> findGroupResourceByGroupId(Long groupId);
}

package cn.zucc.graduation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.ProjectResource;

public interface ProjectResourceDao extends PagingAndSortingRepository<ProjectResource, Long>, JpaSpecificationExecutor<ProjectResource> {

	@Query("select g from ProjectResource g join g.project p on p.id = ?1")
	List<ProjectResource> findProjectResourceByProjectId(Long projectId);
}

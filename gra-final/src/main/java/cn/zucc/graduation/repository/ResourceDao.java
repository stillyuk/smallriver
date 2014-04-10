package cn.zucc.graduation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import cn.zucc.graduation.entity.Resource;

public interface ResourceDao extends CrudRepository<Resource, Long>, JpaSpecificationExecutor<Resource> {

	List<Resource> queryResourceByUserId(Long userId);

	Resource getResourceByIdAndUserId(Long resouceId, Long userId);

}

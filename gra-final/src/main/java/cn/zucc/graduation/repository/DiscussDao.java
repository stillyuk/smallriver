package cn.zucc.graduation.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.Discuss;

public interface DiscussDao extends PagingAndSortingRepository<Discuss, Long>, JpaSpecificationExecutor<Discuss> {

}

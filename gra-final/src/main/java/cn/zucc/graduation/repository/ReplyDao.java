package cn.zucc.graduation.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.Reply;

public interface ReplyDao extends PagingAndSortingRepository<Reply, Long>, JpaSpecificationExecutor<Reply> {

}

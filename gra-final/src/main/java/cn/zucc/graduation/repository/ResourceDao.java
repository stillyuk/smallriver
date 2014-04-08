package cn.zucc.graduation.repository;

import org.springframework.data.repository.CrudRepository;

import cn.zucc.graduation.entity.Resource;

public interface ResourceDao extends CrudRepository<Resource, Long> {

}

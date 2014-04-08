package cn.zucc.graduation.repository;

import org.springframework.data.repository.CrudRepository;

import cn.zucc.graduation.entity.User;

public interface DiscussDao extends CrudRepository<User, Long> {

}

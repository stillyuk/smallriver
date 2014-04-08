package cn.zucc.graduation.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {
	public User queryByLoginName(String name);
	public User queryByLoginNameAndPassword(String username, String password);
}

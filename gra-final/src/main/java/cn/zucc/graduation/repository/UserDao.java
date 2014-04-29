package cn.zucc.graduation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.User;

public interface UserDao extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

	public User queryByLoginName(String name);

	public User queryByLoginNameAndPassword(String username, String password);

	@Modifying
	@Query("select g from Group g join g.users u where u.id=?1")
	public List<Group> findGroupsByUserId(Long userId);

//	public List<User> search(String content);
}

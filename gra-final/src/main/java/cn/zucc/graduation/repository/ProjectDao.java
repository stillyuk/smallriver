package cn.zucc.graduation.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.zucc.graduation.entity.Project;

public interface ProjectDao extends PagingAndSortingRepository<Project, Long>, JpaSpecificationExecutor<Project> {

	public Project queryByProjectName(String name);

/*	public Project queryByLoginNameAndPassword(String username, String password);

	@Modifying
	@Query("select g from Group g join g.users u where u.id=?1")
	public List<Project> findGroupsByUserId(Long userId);*/

//	public List<User> search(String content);
}

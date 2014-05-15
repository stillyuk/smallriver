package cn.zucc.graduation.service.project;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zucc.graduation.entity.Project;
import cn.zucc.graduation.repository.ProjectDao;

/**
 * @author jiangyukun
 * @since 2014-05-11
 */
@Service
@Transactional
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;

	public Project getProject(Long projectId) {
		return projectDao.findOne(projectId);
	}

	public List<Project> findProjectsByUserId(Long userId) {
		return projectDao.findProjectsByUserId(userId);
	}

	public void save(Project project) {
		projectDao.save(project);
	}

	public List<Project> getAllProjects() {
		return (List<Project>) projectDao.findAll();
	}

	public boolean isProjectMemberQueryByUserId(Long projectId, Long currentUserId) {
		List<Project> projects = projectDao.isProjectMemberQueryByUserId(projectId, currentUserId);
		if (projects != null && projects.size() > 0) {
			return true;
		}
		return false;
	}

}

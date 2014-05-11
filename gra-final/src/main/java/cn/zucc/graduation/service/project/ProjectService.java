package cn.zucc.graduation.service.project;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zucc.graduation.entity.Project;
import cn.zucc.graduation.repository.ProjectDao;

/**
 * @author jiangyukun
 * @since 2014-05-11
 */
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;

	public Project getProject(Long projectId) {
		return projectDao.findOne(projectId);
	}

}

package cn.zucc.graduation.service.project;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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

	public Project getProjectByProjectName(String projectName) {
		return projectDao.getProjectByProjectName(projectName);
	}

	public List<Project> search(String project) {
		Specification<Project> spec = buildSpecification(project);
		List<Project> groups = projectDao.findAll(spec);
		return groups;
	}

	protected Specification<Project> buildSpecification(final String name) {
		Specification<Project> spec = new Specification<Project>() {
			public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				query.where(cb.like(root.<String> get("projectName"), "%" + name + "%"));
				return query.getGroupRestriction();
			}
		};
		return spec;
	}
}

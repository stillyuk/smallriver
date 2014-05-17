package cn.zucc.graduation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "gra_project")
public class Project extends GeneralEntity {
	private Long id;
	private String projectName;
	private Group group;
	private List<ProjectResource> projectResource;

	@Id
	@GeneratedValue(generator = "nativeGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "nativeGenerator", sequenceName = "GRA_PROJECT_SEQUENCE")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@ManyToOne
	@JoinColumn(name = "group_id")
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@OneToMany
	@JoinColumn(name = "projectId")
	public List<ProjectResource> getGroupResources() {
		return projectResource;
	}

	public void setGroupResources(List<ProjectResource> projectResource) {
		this.projectResource = projectResource;
	}
}

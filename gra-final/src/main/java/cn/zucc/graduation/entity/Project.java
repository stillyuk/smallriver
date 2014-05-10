package cn.zucc.graduation.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "gra_project")
public class Project extends GeneralEntity {
	private Long id;
	private String projectName;
	private Group group;
	private List<GroupResource> groupResources;

	@Id
	@GeneratedValue(generator = "nativeGenerator")
	@GenericGenerator(name = "nativeGenerator", strategy = "native")
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
	public List<GroupResource> getGroupResources() {
		return groupResources;
	}

	public void setGroupResources(List<GroupResource> groupResources) {
		this.groupResources = groupResources;
	}
}

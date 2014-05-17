package cn.zucc.graduation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "gra_group")
public class Group extends GeneralEntity {
	private Long id;
	private String groupName;
	private List<User> users;
	private User manager;
	private List<Project> projects;

	@Id
	@GeneratedValue(generator = "nativeGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "nativeGenerator", sequenceName = "GRA_GROUP_SEQUENCE")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotBlank
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@ManyToMany
	@JoinTable(name = "gra_user_group", joinColumns = { @JoinColumn(name = "groups_id") })
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@ManyToOne
	@JoinColumn(name = "manager_id")
	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	@OneToMany
	@Column(name = "group_id")
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
}

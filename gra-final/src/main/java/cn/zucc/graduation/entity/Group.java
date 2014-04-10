package cn.zucc.graduation.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "gra_group")
public class Group extends IdEntity {
	private String groupName;
	private Date createDate;
	private List<User> users;
	private User manager;
	private List<GroupResource> groupResources;

	@NotBlank
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
	@JoinColumn(name = "groupid")
	public List<GroupResource> getGroupResources() {
		return groupResources;
	}

	public void setGroupResources(List<GroupResource> groupResources) {
		this.groupResources = groupResources;
	}
}

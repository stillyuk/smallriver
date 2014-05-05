package cn.zucc.graduation.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "gra_user")
public class User extends IdEntity {
	private String loginName;
	private String name;
	private String password;
	private String email;
	private String roles;
	private Date registerDate;
	private List<Group> groups;

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}

	@NotBlank
	@Column(name = "loginName", unique = true)
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	@Transient
	public List<String> getRoleList() {
		return Arrays.asList(roles.split(","));
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@ManyToMany
	@JoinTable(name = "gra_user_group", joinColumns = { @JoinColumn(name = "users_id") })
	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public String toString() {
		return loginName;
	}
}
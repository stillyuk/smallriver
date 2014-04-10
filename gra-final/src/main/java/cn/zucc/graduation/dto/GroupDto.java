package cn.zucc.graduation.dto;

import java.util.List;

import cn.zucc.graduation.entity.User;

public class GroupDto {
	private String groupName;
	private String createDate;
	private List<User> users;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}

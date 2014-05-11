package cn.zucc.graduation.dto;

import java.util.ArrayList;
import java.util.List;

import cn.zucc.graduation.core.SystemDateFormat;
import cn.zucc.graduation.entity.Friend;

/**
 * @author jiangyukun
 * @since 2014-05-10 15:07
 */
public class FriendDto {
	private String id;
	private String username;
	private String nickname;
	private String addDate;

	public static List<FriendDto> dto(List<Friend> friends) {
		List<FriendDto> friendDtos = new ArrayList<FriendDto>();
		for (Friend friend : friends) {
			FriendDto friendDto = new FriendDto();
			friendDto.setId(friend.getTo().getId().toString());
			friendDto.setUsername(friend.getTo().getLoginName());
			friendDto.setNickname(friend.getTo().getName());
			friendDto.setAddDate(SystemDateFormat.getSimpleDateFormat().format(friend.getDate()));
			friendDtos.add(friendDto);
		}
		return friendDtos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAddDate() {
		return addDate;
	}

	public void setAddDate(String addDate) {
		this.addDate = addDate;
	}

	public String toString() {
		return username;
	}
}

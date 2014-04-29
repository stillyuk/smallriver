package cn.zucc.graduation.service.friend;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zucc.graduation.entity.Friend;
import cn.zucc.graduation.repository.FriendDao;

@Service
@Transactional
public class FriendService {
	@Autowired
	private FriendDao friendDao;

	public List<Friend> findFriendsByUserId(Long userId) {
		return friendDao.findFriendsByUserId(userId);
	}
}

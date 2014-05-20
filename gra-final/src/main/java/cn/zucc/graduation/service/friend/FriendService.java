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

	public Friend save(Friend friend) {
		return friendDao.save(friend);
	}

	public Boolean isFriendQuerybyFromAndTo(Long fromUserId, Long toUserId) {
		List<Friend> friends = friendDao.querybyFromAndTo(fromUserId, toUserId);
		if (friends != null && friends.size() != 0) {
			return true;
		}
		return false;
	}

	public void deleteRelation(Long currentUserId, Long deleteId) {
		friendDao.delete(friendDao.findFriendByFromAndTo(currentUserId, deleteId));
		friendDao.delete(friendDao.findFriendByFromAndTo(deleteId, currentUserId));
	}
}

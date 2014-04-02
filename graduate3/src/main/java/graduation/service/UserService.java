package graduation.service;

import graduation.dao.UserDao;
import graduation.domain.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jiangyukun
 * @since 2014-03-12 13:00
 */
@Service
@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;

	public List<User> query(User user) {
		return userDao.query(user);
	}

	public User queryByUsername(String username) {
		List<User> users = userDao.queryByname(username);
		if (users != null) {
			return users.get(0);
		}
		return null;
	}

	public User queryById(String id) {
		return userDao.queryById(id);
	}

	public Object add(User user) {
		return userDao.add(user);
	}
}

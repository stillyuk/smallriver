package cn.zucc.graduation.service.acount;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zucc.graduation.entity.Group;
import cn.zucc.graduation.entity.User;
import cn.zucc.graduation.repository.UserDao;

@Service
@Transactional
public class AccountService {
	@Autowired
	private UserDao userDao;

	public User save(User user) {
		user.setRegisterDate(new Date());
		user.setRoles("user");
		return userDao.save(user);
	}

	public User updateUser(User user) {
		return userDao.save(user);
	}

	public void delete(User user) {
		userDao.delete(user);
	}

	public List<User> getAllUser() {
		return (List<User>) userDao.findAll();
	}

	public User getUser(Long id) {
		return userDao.findOne(id);
	}

	public Page<User> getUserPage(Long userId, int pageNumber, int pageSize, String sortType) {
		Pageable pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		// Specification<User> spe = buildSpecification();
		return userDao.findAll(null, pageRequest);
	}

	public User queryByLoginName(String name) {
		return userDao.queryByLoginName(name);
	}

	public User queryByLoginNameAndPassword(String username, String password) {
		return userDao.queryByLoginNameAndPassword(username, password);
	}

	private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		} else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "loginName");
		}
		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}

	protected Specification<User> buildSpecification() {
		Specification<User> spec = new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("loginName"), "admin");
			}
		};
		return spec;
	}

	public User findUserByLoginName(String loginName) {
		return userDao.queryByLoginName(loginName);
	}

	public List<Group> findGroupsByUserId(Long userId) {
		return userDao.findGroupsByUserId(userId);
	}
}

package graduation.dao;

import graduation.domain.User;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * @author jiangyukun
 * @since 2014-03-12 13:03
 */
@SuppressWarnings("unchecked")
public class UserDao extends HibernateDaoSupport {

	public Object add(final User user) {
		return getHibernateTemplate().save(user);
	}

	public List<User> query(final User user) {
		HibernateCallback<List<User>> action = new HibernateCallback<List<User>>() {
			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(User.class);
				criteria.add(Restrictions.eq("username", user.getUsername())).add(Restrictions.eq("password", user.getPassword()));
				List<User> users = criteria.list();
				return users;
			}
		};
		return getHibernateTemplate().execute(action);
	}

	public User queryById(String id) {
		return getHibernateTemplate().get(User.class, id);
	}

	public List<User> queryByname(final String username) {
		HibernateCallback<List<User>> action = new HibernateCallback<List<User>>() {
			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(User.class);
				criteria.add(Restrictions.eq("username", username));
				List<User> users = criteria.list();
				return users;
			}
		};
		return getHibernateTemplate().execute(action);
	}
}

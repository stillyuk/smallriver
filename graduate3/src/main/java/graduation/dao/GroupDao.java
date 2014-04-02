package graduation.dao;

import graduation.domain.Group;
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
 * @since 2014-03-19
 */
@SuppressWarnings("unchecked")
public class GroupDao extends HibernateDaoSupport {

	public Object add(final Group group) {
		return getHibernateTemplate().execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				return (Object) session.save(group);
			}
		});
	}

	public List<Group> query(final Group group) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Group>>() {
			@Override
			public List<Group> doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(Group.class);
				criteria.add(Restrictions.eq("username", group.getUuid()));
				return criteria.list();
			}
		});
	}

	public List<Group> queryByUser(final User user) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Group>>() {
			@Override
			public List<Group> doInHibernate(Session session) throws HibernateException {
				Criteria c = session.createCriteria(Group.class);
				c.add(Restrictions.eq("manager", user));
				return c.list();
			}
		});
	}

	public List<Group> queryByGroupName(final String groupName) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Group>>() {
			@Override
			public List<Group> doInHibernate(Session session) throws HibernateException {
				Criteria c = session.createCriteria(Group.class);
				c.add(Restrictions.eq("groupName", groupName));
				return c.list();
			}
		});
	}
}

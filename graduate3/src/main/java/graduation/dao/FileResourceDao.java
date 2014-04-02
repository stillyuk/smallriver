package graduation.dao;

import graduation.domain.FileResource;
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
 * @since 2014-03-30 22:17
 */
@SuppressWarnings("unchecked")
public class FileResourceDao extends HibernateDaoSupport {
	public Object add(final FileResource fileResource) {
		return getHibernateTemplate().save(fileResource);
	}

	public void update(final FileResource fileResource) {
		getHibernateTemplate().update(fileResource);
	}

	public List<FileResource> query(final String id) {
		return getHibernateTemplate().execute(new HibernateCallback<List<FileResource>>() {
			public List<FileResource> doInHibernate(Session session) throws HibernateException {
				Criteria c = session.createCriteria(FileResource.class);
				return c.list();
			}
		});
	}

	public List<FileResource> queryByUserAndFileName(final User user, final String fileName) {
		return getHibernateTemplate().execute(new HibernateCallback<List<FileResource>>() {
			public List<FileResource> doInHibernate(Session session) throws HibernateException {
				Criteria c = session.createCriteria(FileResource.class);
				c.add(Restrictions.eq("fileName", fileName)).add(Restrictions.eq("user", user));
				return c.list();
			}
		});
	}

	public List<FileResource> getAll() {
		return getHibernateTemplate().execute(new HibernateCallback<List<FileResource>>() {
			public List<FileResource> doInHibernate(Session session) throws HibernateException {
				Criteria c = session.createCriteria(FileResource.class);
				return c.list();
			}
		});
	}
}

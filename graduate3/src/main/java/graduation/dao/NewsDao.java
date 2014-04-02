package graduation.dao;

import graduation.domain.News;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * @author jiangyukun
 * 
 */
public class NewsDao extends HibernateDaoSupport {
	public List<News> query(final String id) {
		HibernateCallback<List<News>> action = new HibernateCallback<List<News>>() {
			@Override
			@SuppressWarnings("unchecked")
			public List<News> doInHibernate(Session session) throws HibernateException {
				Criteria c = session.createCriteria(News.class);
				c.addOrder(Order.desc("top"));
				if (id != null && !id.equals("")) {
					c.add(Restrictions.eq("id", id));
				}
				return c.list();
			}
		};
		return getHibernateTemplate().execute(action);
	}

	public Object add(final News news) {
		HibernateCallback<Object> action = new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				news.setNewsDate(new Date());
				return session.save(news);
			}
		};
		return getHibernateTemplate().execute(action);
	}
}

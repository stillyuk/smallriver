package graduation.dao;

import graduation.domain.SystemProperty;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 * @author jiangyukun
 * @since 2014-03-31 0:00
 */
public class SystemPropertyDao extends HibernateDaoSupport {
	public Object add(SystemProperty systemProperty) {
		return getHibernateTemplate().save(systemProperty);
	}
}

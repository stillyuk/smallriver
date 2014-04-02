package graduation.service;

import graduation.dao.SystemPropertyDao;
import graduation.domain.SystemProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jiangyukun
 * @since 2014-03-31 0:06
 */
@Service
@Transactional
public class SystemPropertyService {
	@Autowired
	private SystemPropertyDao systemPropertyDao;

	public Object add(SystemProperty systemProperty) {
		return systemPropertyDao.add(systemProperty);
	}
}

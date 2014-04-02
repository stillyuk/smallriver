package graduation.service;

import graduation.dao.NewsDao;
import graduation.domain.News;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author jiangyukun
 * 
 */
@Service
@Transactional
public class NewsService {
	@Autowired
	NewsDao newsDao;

	public List<News> query(String id) {
		return newsDao.query(id);
	}

	public void add(News news) {
		newsDao.add(news);
	}
}

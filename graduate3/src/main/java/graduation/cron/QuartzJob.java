package graduation.cron;

import graduation.core.News2Htm;
import graduation.domain.News;
import graduation.service.NewsService;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author jiangyukun
 * @since 2014-03-12 12:55
 */
@Component
public class QuartzJob {
	protected Log logger = LogFactory.getLog(getClass());

	@Autowired
	private NewsService newsService;

	public void work() {
		if (logger.isInfoEnabled()) {
			logger.info("正在进行主页静态化...");
		}
		List<News> news = newsService.query(null);
		try {
			News2Htm.generate(news);
		} catch (Exception e) {
		}
		if (logger.isDebugEnabled()) {
			logger.info("主页静态化完成！");
		}
	}
}

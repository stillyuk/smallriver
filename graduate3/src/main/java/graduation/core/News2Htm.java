package graduation.core;

import graduation.domain.News;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * @author jiangyukun
 * @since 2014-03-12
 */
@Component
public class News2Htm {
	static Log logger = LogFactory.getLog(News2Htm.class);

	private static Context context;

	public static void generate(List<News> news) {
		if (!preCheck()) {
			return;
		}
		for (int i = 0; i < news.size(); i++) {
			String dir = new SimpleDateFormat("yyyy-MM-dd").format(news.get(i).getNewsDate());
			String urlPath = context.getSchema() + "://" + context.getServerName() + ":" + context.getServerPort()
					+ context.getContextPath() + "/news/singleNews.news?id=" + news.get(i).getId() + "&dir=" + dir;
			URL url;
			try {
				url = new URL(urlPath);
				URLConnection connection = url.openConnection();
				connection.connect();
				HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
				int httpResult = httpURLConnection.getResponseCode();
				if (httpResult != HttpURLConnection.HTTP_OK) {
					System.out.println("连接失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static boolean preCheck() {
		context = ContextProvider.getContext();
		if (context == null || context.getSchema() == null || context.getServerName() == null
				|| context.getServerPort() == 0 || context.getContextPath() == null) {
			return false;
		}
		return true;
	}
}

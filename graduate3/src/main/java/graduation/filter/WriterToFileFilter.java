package graduation.filter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author jiangyukun
 * @since 2014-03-12 20:12
 */
public class WriterToFileFilter implements Filter {
	private final Log log = LogFactory.getLog(WriterToFileFilter.class);

	private ServletContext servletContext;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (req.getRequestURI().endsWith("add.ns")) {
			chain.doFilter(request, response);
			return;
		}
		String dir = request.getParameter("dir");
		String fileName = request.getParameter("id");
		String rootPath = servletContext.getRealPath("/");

		if (fileName == null)
			fileName = "index";
		if (dir == null)
			dir = "";

		File absoluteDir = new File(rootPath + dir);
		if (!absoluteDir.exists())
			absoluteDir.mkdir();
		final PrintWriter writer = new PrintWriter(rootPath + dir + File.separatorChar + fileName + ".htm");
		HttpServletResponse rep = new HttpServletResponseWrapper(res) {
			public PrintWriter getWriter() {
				return writer;
			}
		};
		chain.doFilter(request, rep);
		if (log.isInfoEnabled()) {
			log.info("输出: " + dir + File.separatorChar + fileName + ".htm");
		}
		response.getWriter().write("<h1>主页静态化完成</h1>" + "内容已输出到服务器目录" + rootPath + dir + fileName + ".htm中");
		writer.flush();
		writer.close();
	}

	public void init(FilterConfig config) throws ServletException {
		servletContext = config.getServletContext();
	}

	public void destroy() {
		servletContext = null;
	}
}

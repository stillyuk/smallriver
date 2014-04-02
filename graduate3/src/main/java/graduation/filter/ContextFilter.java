package graduation.filter;

import graduation.core.Context;
import graduation.core.ContextProvider;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author jiangyukun
 * @since 2014-03-12 15:12
 */
public class ContextFilter implements Filter {
	Log logger = LogFactory.getLog(ContextFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		logger.warn(httpRequest.getServletPath());
		ThreadLocal<HttpSession> session = new ThreadLocal<HttpSession>();
		session.set(httpRequest.getSession());
		Context.session = session;
		Context context = new Context();
		context.setContext(httpRequest);
		ContextProvider.setContext(context);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}
}

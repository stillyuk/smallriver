package graduation.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

/**
 * @author jiangyukun
 * @since 2014-03-13 18:59
 */
@Component
public class Context {
	private String schema;

	private String serverName;

	private int serverPort;

	private String contextPath;

	public static ThreadLocal<HttpSession> session;

	public void setContext(HttpServletRequest request) {
		this.schema = request.getScheme();
		this.serverName = request.getServerName();
		this.serverPort = request.getServerPort();
		this.contextPath = request.getContextPath();
	}

	public String getContextPath() {
		return contextPath;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public int getServerPort() {
		return serverPort;
	}

	public void setServerPort(int serverPort) {
		this.serverPort = serverPort;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
}

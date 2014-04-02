package graduation.interceptor;

import graduation.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		User user = (User) modelAndView.getModel().get("user");
		if (user.getUuid() != null && user.getUsername() != null) {
			request.getSession().setAttribute("userId", user.getUuid());
			request.getSession().setAttribute("username", user.getUsername());
			modelAndView.getModel().remove("user");
		}
	}
}
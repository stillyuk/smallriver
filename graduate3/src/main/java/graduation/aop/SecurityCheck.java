package graduation.aop;

import graduation.core.Context;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author jiangyukun
 * @since 2014-03-12 13:58
 */
@Component
@Aspect
public class SecurityCheck {

	Log logger = LogFactory.getLog(SecurityCheck.class);

	/**
	 * @since 2014-03-18 16:59
	 */
	// @Before("execution(* graduation.web.*.userHome(..))")
	public void start() {
		HttpSession session = Context.session.get();
		if (session != null) {
			logger.warn(session.getAttribute("username"));

		}
	}
}

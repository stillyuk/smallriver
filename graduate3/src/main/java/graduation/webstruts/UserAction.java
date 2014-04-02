package graduation.webstruts;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author jiangyukun
 * @since 2014-03-12 13:59
 */
@SuppressWarnings("serial")
public class UserAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute("a", "a");
		ActionContext.getContext().put("b", "b");
		return super.execute();
	}
}

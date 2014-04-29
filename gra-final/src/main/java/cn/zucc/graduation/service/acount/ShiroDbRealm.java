package cn.zucc.graduation.service.acount;

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.zucc.graduation.entity.User;

/**
 * @author jiangyukun
 * 
 */
@Component
public class ShiroDbRealm extends AuthorizingRealm {

	@Autowired
	private AccountService accountService;

	public AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = accountService.queryByLoginNameAndPassword(token.getUsername(), new String(token.getPassword()));
		if (user != null) {
			return new SimpleAuthenticationInfo(new ShiroUser(user.getId(), user.getName(), user.getLoginName()), user.getPassword(), getName());
		}
		return null;
	}

	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		User user = accountService.findUserByLoginName(shiroUser.loginName);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(user.getRoleList());
		return info;
	}

	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -8404073138782337443L;
		private Long id;
		private String name;
		private String loginName;

		public ShiroUser(Long id, String name, String loginName) {
			this.id = id;
			this.name = name;
			this.loginName = loginName;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLoginName() {
			return loginName;
		}

		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}

		public String toString() {
			return loginName;
		}
	}
}

package cn.zucc.graduation.web.shiro;

import org.apache.shiro.SecurityUtils;

import cn.zucc.graduation.service.acount.ShiroDbRealm.ShiroUser;

public class ShiroUserUtil {
	public static Long getCurrentUserId() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.getId();
	}
}

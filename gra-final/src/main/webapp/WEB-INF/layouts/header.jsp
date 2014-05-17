<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="header">
	<div id="title">
		<shiro:notAuthenticated>
			<h1><a href="${ctx}">浙江大学城市学院</a><small>&nbsp;资源管理系统</small>
		</shiro:notAuthenticated>
	    <shiro:user>
		    <nav class="navbar navbar-default">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
		
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="${ctx}">首页</a></li>
						<li><a href="${ctx}/friend">好友</a></li>
						<li><a href="${ctx}/file/upload">个人资源</a></li>
						<li><a href="${ctx}/group">团队</a></li>
						<li><a href="${ctx}/project">项目</a></li>
					</ul>
					<form class="navbar-form navbar-left" role="search" action="${ctx}/search">
						<div class="form-group">
							<input type="text" name="content" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<span class="btn-group pull-right">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
							<i class="icon-user"></i> <shiro:principal property="name"/>
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<shiro:hasRole name="admin">
								<li><a href="${ctx}/admin/user">Admin Users</a></li>
								<li class="divider"></li>
							</shiro:hasRole>
							<li><a href="${ctx}/profile">Edit Profile</a></li>
							<li><a href="${ctx}/logout">Logout</a></li>
						</ul>
					</span>
				</div>
			</nav>
		</shiro:user>
		</h1>
	</div>
</div>
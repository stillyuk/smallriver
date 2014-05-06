<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title>用户激活</title>
</head>

<body>
	<ol class="breadcrumb">
		<li class="active">注册</li>
		<li>激活</li>
	</ol>
	<div class="alert alert-danger">
		<a href="${xxx}">${xxx}</a>
		用户${user.loginName}注册成功， 系统已发送邮件到您注册的邮箱地址${user.email},激活后才能登陆，
		立即登陆<a href="${mailServer}">${mailServer}</a>进行验证
	</div>
</body>
</html>

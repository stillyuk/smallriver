<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script>
	$(function() {
		$("#loginForm").validate();
	});
</script>
</head>
<body>
	<form id="loginForm" actin="${ctx}/login" method="post" class="form-horizontal" role="form">
		<c:if test="${not empty shiroLoginFailure}">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4 alert alert-danger">
					<button class="close" data-dismiss="alert">×</button>
					登录失败，请重新登录或登录邮箱激活账号
				</div>
			</div>
		</c:if>
		<c:if test="${not empty message}">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4 alert alert-info">
					<button class="close" data-dismiss="alert">×</button>
					${message}
				</div>
			</div>
		</c:if>
		<div class="form-group">
			<label class="col-sm-2 control-label">用户名：</label>
			<div class="col-sm-4">
				<input id="username" name="username" type="text" value="${username}" class="form-control required" />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-2 control-label">密码：</label>
			<div class="col-sm-4">
				<input id="password" name="password" type="password" class="form-control required" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<div class="checkbox">
					<label>
						<input type="checkbox" id="rememberMe" name="rememberMe" /> Remember me
					</label>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<input type="submit" class="btn btn-primary" value="登录" />
				<a class="btn" href="${ctx}/register">注册</a>
			</div>
		</div>
	</form>
</body>
</html>
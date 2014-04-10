<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户注册</title>
	<script>
		$(function() {
			$("#loginName").focus();
			$("#inputForm").validate({
				rules: {
					loginName: {
						remote: "${ctx}/register/checkLoginName"
					}
				},
				messages: {
					loginName: {
						remote: "用户登录名已存在"
					}
				}
			});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/register" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>用户注册</small></legend>
			<div class="form-group">
				<label for="loginName" class="col-sm-2 control-label">登录名:</label>
				<div class="col-xs-3">
					<input type="text" id="loginName" name="loginName" class="form-control required" minlength="3"/>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">用户名:</label>
				<div class="col-xs-3">
					<input type="text" id="name" name="name" class="form-control required"/>
				</div>
			</div>
			<div class="form-group">
				<label for="plainPassword" class="col-sm-2 control-label">密码:</label>
				<div class="col-xs-3">
					<input type="password" id="password" name="password" class="form-control required"/>
				</div>
			</div>
			<div class="form-group">
				<label for="confirmPassword" class="col-xs-2 control-label">确认密码:</label>
				<div class="col-xs-3">
					<input type="password" id="confirmPassword" name="confirmPassword" class="form-control required" equalTo="#password"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-xs-offset-2 col-xs-3">
					<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
					<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
				</div>
			</div>
		</fieldset>
	</form>
</body>
</html>

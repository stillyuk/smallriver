<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>资料修改</title>
</head>
<body>
	<form id="inputForm" action="${ctx}/profile" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${user.id}"/>
		<fieldset>
			<legend><small>资料修改</small></legend>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">用户名:</label>
				<div class="col-sm-4">
					<input type="text" id="name" name="name" value="${user.name}" class="form-control required"/>
				</div>
			</div>
			<div class="form-group">
				<label for="plainPassword" class="col-sm-2 control-label">密码:</label>
				<div class="col-sm-4">
					<input type="password" id="plainPassword" name="plainPassword" class="form-control required"/>
				</div>
			</div>
			<div class="form-group">
				<label for="plainPassword" class="col-sm-2 control-label">新密码:</label>
				<div class="col-sm-4">
					<input type="password" id="plainPassword" name="password" class="form-control" placeholder="不更换密码则不用输入"/>
				</div>
			</div>
			<div class="form-group">
				<label for="confirmPassword" class="col-sm-2 control-label">确认新密码:</label>
				<div class="col-sm-4">
					<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" equalTo="#password" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
					<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
				</div>
			</div>
		</fieldset>
	</form>
	<script>
		$(function() {
			$("#name").focus();
			$("#inputForm").validate();
		});
	</script>
</body>
</html>

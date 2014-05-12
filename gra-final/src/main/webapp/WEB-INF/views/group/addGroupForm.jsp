<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<title>用户注册</title>
<script>
</script>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="${ctx}/group">团队</a></li>
		<li class="active">新建团队</li>
	</ol>
	<form id="inputForm" action="${ctx}/group/create" method="post" class="form-horizontal">
		<fieldset>
			<div class="form-group">
				<label for="groupName" class="col-sm-2 control-label">团队名:</label>
				<div class="col-sm-3">
					<input type="text" id="groupName" name="groupName" class="form-control required" minlength="3"/>
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
</body>
</html>

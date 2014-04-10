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
	<ul class="nav nav-tabs">
		<li><a href="${ctx}">Home</a></li>
		<li><a href="${ctx}/file/upload">文件上传</a></li>
		<li><a href="${ctx}/file/download">文件下载</a></li>
		<li class="active"><a href="${ctx}/group">群组</a></li>
	</ul>
	<div style="height: 50px;"></div>
	<form id="inputForm" action="${ctx}/group/create" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>添加群组</small></legend>
			<div class="form-group">
				<label for="loginName" class="col-sm-2 control-label">组名:</label>
				<div class="col-xs-3">
					<input type="text" id=groupName name="groupName" class="form-control required" minlength="3"/>
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

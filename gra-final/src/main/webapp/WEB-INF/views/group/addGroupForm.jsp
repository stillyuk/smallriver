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
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${ctx}">首页</a></li>
				<li><a href="${ctx}/file/upload">文件上传</a></li>
				<li><a href="${ctx}/file/download">文件下载</a></li>
				<li><a href="${ctx}/group">群组</a></li>
			</ul>
			<form class="navbar-form navbar-left" role="search" action="${ctx}/search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</nav>
	<form id="inputForm" action="${ctx}/group/create" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>添加群组</small></legend>
			<div class="form-group">
				<label for="loginName" class="col-sm-2 control-label">组名:</label>
				<div class="col-sm-3">
					<input type="text" id=groupName name="groupName" class="form-control required" minlength="3"/>
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

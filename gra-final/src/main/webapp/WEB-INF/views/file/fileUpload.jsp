<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
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
				<li class="active"><a href="${ctx}/file/upload">文件上传</a></li>
				<li><a href="${ctx}/file/download">文件下载</a></li>
				<li><a href="${ctx}/group">群组</a></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</nav>
	<div class="alert alert-info">
		一共上传了${total}个文件
		<button class="close" data-dismiss="alert">×</button>
	</div>
	<c:if test="${not empty message}">
		<div class="alert alert-success">
			上传成功
			<button class="close" data-dismiss="alert">×</button>
		</div>
	</c:if>
	<div>
		<form method="POST" action="upload" enctype="multipart/form-data">
			<ul class="list-group">
				<li class="list-group-item">
					<input type="file" name="file" />
				</li>
				<li class="list-group-item">
					<input type="submit" value="提交" class="btn" />
				</li>
			</ul>
		</form>
	</div>
</body>
</html>
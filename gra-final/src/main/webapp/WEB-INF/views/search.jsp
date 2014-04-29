<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
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
					<input type="text" name="content" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</nav>

	<c:if test="${not empty users}">
		<c:forEach items="${users}" var="user">
			<div class="alert alert-info">
				<button class="close" data-dismiss="alert" onclick="location.href='${ctx}/message/updateState?messageId=${user.id}'">×</button>
				用户：${user.loginName}
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${not empty groups}">
		<c:forEach items="${groups}" var="group">
			<div class="alert alert-info">
				<button class="close" data-dismiss="alert" onclick="location.href='${ctx}/message/updateState?messageId=${group.id}'">×</button>
				群组：${group.groupName}
			</div>
		</c:forEach>
	</c:if>
</body>
</html>
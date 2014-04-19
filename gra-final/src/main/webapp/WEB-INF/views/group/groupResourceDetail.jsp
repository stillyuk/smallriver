<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>group</title>
<script type="text/javascript">
function replyTo(e) {
	$("#discuss").val("回复@"+$(e).parent().children().first().text()+"：");
}
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

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="${ctx}">首页</a></li>
				<li><a href="${ctx}/file/upload">文件上传</a></li>
				<li><a href="${ctx}/file/download">文件下载</a></li>
				<li class="active"><a href="${ctx}/group">群组</a></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</nav>

	<span class="label label-default">群资源</span>
	<ul class="list-group">
		<li class="list-group-item">资源名：${groupResource.name}</li>
		<li class="list-group-item">下载次数：${groupResource.downloadTimes}</li>
		<li class="list-group-item">上传用户：${groupResource.uploadUser.loginName}</li>
		<li class="list-group-item">上传时间：${groupResource.uploadDate}</li>
		<li class="list-group-item">下载资源：<a href="#">点击下载</a></li>
		<li class="list-group-item">评论：</li>
		<c:forEach items="${groupResource.discusses}" var="discuss">
			<li class="list-group-item">
				<a href="#">${discuss.user.loginName}</a>：
				<c:if test="${not empty discuss.replyTo}">回复<a href="#">@${discuss.replyTo.loginName}:</a></c:if>${discuss.content}
				<button onclick="replyTo(this)" value="a">回复</button>
			</li>
		</c:forEach>
		<li class="list-group-item">
			<form action="${ctx}/group/addDiscuss" class="form-horizontal" role="form">
				<div class="form-group">
					<input type="hidden" name="groupResourceId" value="${groupResource.id}" />
					<input type="text" id="discuss" name="discuss" class="form-control" />
					<input class="btn btn-primary" type="submit" value="添加评论" />
				</div>
			</form>
		</li>
	</ul>
</body>
</html>
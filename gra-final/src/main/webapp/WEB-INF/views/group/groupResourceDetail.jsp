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
	<span class="label label-default">群资源</span>
	<ul class="list-group">
		<li class="list-group-item">资源名：${groupResource.name}</li>
		<li class="list-group-item">下载次数：${groupResource.downloadTimes}</li>
		<li class="list-group-item">上传用户：${groupResource.uploadUser.loginName}</li>
		<li class="list-group-item">上传时间：${groupResource.uploadDate}</li>
		<li class="list-group-item">下载资源：<a href="${ctx}/file/download/groupResource/${groupResource.id}">点击下载</a></li>
		<li class="list-group-item">评论：</li>
		<c:forEach items="${groupResource.discusses}" var="discuss">
			<li class="list-group-item">
				<a href="#">${discuss.user.loginName}</a>：
				<c:if test="${not empty discuss.replyTo}">回复<a href="${ctx}/user/info?userId=${discuss.replyTo.id}">@${discuss.replyTo.loginName}:</a></c:if>${discuss.content}
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
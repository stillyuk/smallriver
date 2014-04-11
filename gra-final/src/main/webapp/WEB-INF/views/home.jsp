<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}">Home</a></li>
		<li><a href="${ctx}/file/upload">文件上传</a></li>
		<li><a href="${ctx}/file/download">文件下载</a></li>
		<li><a href="${ctx}/group">群组</a></li>
	</ul>
	<div class="btn-group pull-right">
		<a class="btn active" href="${ctx}/message/allSendMessages">发送的消息</a>
		<a class="btn active" href="${ctx}/message/allReceiveMessages">接受的消息</a>
		<a class="btn btn-primary" href="${ctx}/message/sendMessage">发送消息 </a>
	</div>
	<div style="height: 50px;"></div>
	<span class="label label-default">未处理的消息</span>
	<c:if test="${not empty messages}">
		<c:forEach items="${messages}" var="message">
			<div class="alert alert-info">
				<button class="close" data-dismiss="alert" onclick="location.href='${ctx}/message/updateState?messageId=${message.id}'">×</button>
				消息：${message.content}
			</div>
		</c:forEach>
	</c:if>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<div>
		<ul class="nav nav-pills">
	 		<li><a href="${ctx}/index">未处理的消息<span class="badge">${size}</span></a>
			<li class="active"><a href="${ctx}/message/allSendMessages">所有发送的消息</a></li>
			<li><a href="${ctx}/message/allReceiveMessages">所有接受的消息</a></li>
			<li><a href="${ctx}/message/sendMessage">发送消息</a></li>
		</ul>
	</div>
	<div style="height: 50px;"></div>
	<div>
		<c:if test="${not empty messages}">
			<ul class="list-group">
			<c:forEach items="${messages}" var="message">
				<li class="list-group-item">${message.content}</li>
			</c:forEach>
			</ul>
		</c:if>
	</div>
	<div style="clear:both;"></div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>group</title>
</head>
<body>
	<c:if test="${not empty message}">
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-6 alert alert-info">
				<button class="close" data-dismiss="alert">×</button>
				${message}
			</div>
		</div>
	</c:if>
	<div style="clear:both;"></div>
	<div class="btn-group pull-right">
		<a class="btn active" href="${ctx}/group/allGroups">查看所有团队</a>
		<a class="btn btn-primary" href="${ctx}/group/create">新建团队</a>
	</div>
	<div style="height: 50px;"></div>
	<ul class="list-group">
		<span class="label label-default">所在团队列表</span>
		<c:forEach items="${groups}" var="group">
			<li class="list-group-item">团队名称：<a href="${ctx}/group/groupDetail?groupId=${group.id}">${group.groupName}</a></li>
		</c:forEach>
	</ul>
</body>
</html>
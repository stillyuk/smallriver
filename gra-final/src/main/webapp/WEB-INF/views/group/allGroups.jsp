<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目</title>
</head>
<body>
	<ul class="list-group">
		<span class="label label-default">所有团队列表</span>
		<c:forEach items="${groups}" var="group">
			<li class="list-group-item">
				<a href="${ctx}/group/joinGroup?groupId=${group.id}">申请加入团队</a>
				<div class="col-sm-4">
					组名：<a href="${ctx}/group/groupDetail?groupId=${group.id}">${group.groupName}</a>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
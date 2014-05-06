<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	
	<ol class="breadcrumb">
<!-- 		<li><a href="#">首页</a></li> -->
		<li class="active">查询结果(以下是${content}的查询结果：)</li>
	</ol>
	<c:if test="${not empty users}">
		<c:forEach items="${users}" var="user">
			<div class="alert alert-info">
				用户：<a href="${ctx}/user/info?userId=${user.id}">${user.loginName}</a>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${not empty groups}">
		<c:forEach items="${groups}" var="group">
			<div class="alert alert-info">
				群组：<a href="${ctx}/group/groupDetail?groupId=${group.id}">${group.groupName}</a>
			</div>
		</c:forEach>
	</c:if>
</body>
</html>
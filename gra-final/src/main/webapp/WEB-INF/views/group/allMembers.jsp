<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
</head>
<body>
	<button class="btn" onclick="history.back()">返回</button>
	<ul class="list-group">
		<li class="list-group-item">人数：${groupSize}</li>
		<c:forEach items="${users}" var="user">
			<li class="list-group-item">名称：${user.name}</li>
		</c:forEach>
	</ul>
</body>
</html>
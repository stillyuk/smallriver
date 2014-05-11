<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>group</title>
</head>
<body>
	<ul class="list-group">
<!-- 		<span class="label label-default">好友列表</span> -->
		<c:forEach items="${friends}" var="friend">
			<li class="list-group-item">
				<div>
					<a href="${ctx}/user/info?userId=${friend.id}">${friend.username}</a>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
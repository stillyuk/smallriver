<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GroupResourceDetail</title>
</head>
<body>
	<ul class="list-group">
		<span class="label label-default">群资源信息</span>
		<c:forEach items="${groupResources}" var="groupResource">
			<li class="list-group-item">资源名：
				<a href="${ctx}/group/groupResourceDetail?groupResourceId=${groupResource.id}">${groupResource.name}</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
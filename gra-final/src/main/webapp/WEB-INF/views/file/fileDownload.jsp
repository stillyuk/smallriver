<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件下载</title>
</head>
<body>
	<ul class="list-group">
		<span class="label label-default">文件列表</span>
		<c:forEach items="${resources}" var="resource">
			<li class="list-group-item">
				<a href="${ctx}/file/download/detail?resourceId=${resource.id}" class="thumbnail">
					${resource.name}
				</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
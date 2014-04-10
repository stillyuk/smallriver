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
	<ul class="nav nav-tabs">
		<li><a href="${ctx}">Home</a></li>
		<li><a href="${ctx}/file/upload">文件上传</a></li>
		<li class="active"><a href="${ctx}/file/download">文件下载</a></li>
		<li><a href="${ctx}/group">群组</a></li>
	</ul>
	<div style="height: 50px;"></div>
	<div class="row">
		<c:forEach items="${resources}" var="resource">
			<div class="col-xs-6 col-md-3">
				<a href="${ctx}/file/download/detail?resourceId=${resource.id}" class="thumbnail">${resource.name}
				</a>
			</div>
		</c:forEach>
	</div>
</body>
</html>
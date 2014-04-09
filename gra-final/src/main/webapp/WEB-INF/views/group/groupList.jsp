<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>group</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}">Home</a></li>
		<li class="active"><a href="#">文件上传</a></li>
		<li><a href="${ctx}/file/download">文件下载</a></li>
		<li><a href="${ctx}/group">群组</a></li>
	</ul>
	<div class="row">
		<c:forEach items="${groups}" var="group">
			<div class="col-xs-6 col-md-3">
				<a href="${ctx}/file/download/detail?resourceId=${group.id}" class="thumbnail">${group.groupName}</a>
			</div>
		</c:forEach>
	</div>
</body>
</html>
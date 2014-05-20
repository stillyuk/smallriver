<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GroupResourceDetail</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="${ctx}/project">项目</a></li>
		<li class="active">${project.projectName}</li>
	</ol>
	<ul class="list-group">
		<span class="label label-default">项目资源信息</span>
		<c:forEach items="${projectResources}" var="projectResource">
			<li class="list-group-item">资源名：
				<a href="${ctx}/project/projectResourceDetail?projectResourceId=${projectResource.id}">${projectResource.name}</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
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
	<ol class="breadcrumb">
		<li><a href="${ctx}/group">团队</a></li>
		<li class="active">所有项目</li>
	</ol>
<!-- 	<button class="btn" onclick="history.back()">返回</button> -->
	<ul class="list-group">
		<li class="list-group-item">项目总数：${projectSize}</li>
		<c:forEach items="${projects}" var="project">
			<li class="list-group-item">项目名称：<a href="${ctx}/project/projectDetail?projectId=${project.id}">${project.projectName}</a></li>
		</c:forEach>
	</ul>
</body>
</html>
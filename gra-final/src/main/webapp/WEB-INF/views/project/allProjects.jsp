<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="${ctx}/project">项目</a></li>
		<li class="active">所有项目</li>
	</ol>
	<ul class="list-group">
		<span class="label label-default">所有项目列表</span>
		<c:forEach items="${projects}" var="project">
			<li class="list-group-item">
				<a href="${ctx}/group/joinGroup?groupId=${project.id}">申请加入所在团队</a>
				<div class="col-sm-4">
					项目名：<a href="${ctx}/project/projectDetail?projectId=${project.id}">${project.projectName}</a>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
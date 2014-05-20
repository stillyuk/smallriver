<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目详细信息</title>
</head>
<body>
	<c:if test="${not empty message}">
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-6 alert alert-info">
				<button class="close" data-dismiss="alert">×</button>
				${message}
			</div>
		</div>
	</c:if>
	<div style="clear: both;"></div>
	<div class="btn-group pull-right">
		<a class="btn active" href="${ctx}/project/shareResource?projectId=${project.id}">共享资源</a>
		<a class="btn btn-primary" href="${ctx}/project/listProjectResource?projectId=${project.id}">查看团队资源</a>
	</div>
	<div style="height: 40px;"></div>
	<ol class="breadcrumb">
		<li><a href="${ctx}/project">项目</a></li>
		<li class="active">${project.projectName}</li>
	</ol>
	<ul class="list-group">
		<li class="list-group-item">项目名称：${project.projectName}</li>
		<li class="list-group-item">创建时间：${project.date}</li>
		<li class="list-group-item">所属团队：<a href="${ctx}/group/groupDetail?groupId=${project.group.id}">${project.group.groupName}</a></li>
		<li class="list-group-item">项目管理员：<a href="${ctx}/user/info?userId=${project.group.manager.id}">${project.group.manager.loginName}</a></li>
		<li class="list-group-item">
			<c:if test="${isMember}">
				已经是项目成员了^_^
			</c:if>
			<c:if test="${!isMember}">
				<a href="${ctx}/group/joinGroup?groupId=${group.id}">添加到项目所在团队</a>
			</c:if>
		</li>
	</ul>
	<button class="btn" onclick="history.back()">返回</button>
</body>
</html>
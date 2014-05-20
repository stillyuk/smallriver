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
	<c:if test="${not empty message}">
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-6 alert alert-info">
				<button class="close" data-dismiss="alert">×</button>
				${message}
			</div>
		</div>
	</c:if>
	
	<ol class="breadcrumb">
		<li><a href="${ctx}/group">团队</a></li>
		<li class="active">${group.groupName}</li>
	</ol>

	<ul class="list-group">
		<li class="list-group-item">组名：${group.groupName}</li>
		<li class="list-group-item">创建时间：${group.date}</li>
		<li class="list-group-item">现在人数：${groupSize}<a href="${ctx}/group/allMembers?groupId=${group.id}"> 查看所有成员</a></li>
		<li class="list-group-item">
			项目：${projectSize}
			<c:if test="${projectSize gt 0}">
				<a href="${ctx}/group/allProjects?groupId=${group.id}"> 查看管理的项目</a>
			</c:if>
			<c:if test="${projectSize eq 0}">
				<a href="${ctx}/project/create?groupId=${group.id}"> 新建项目</a>
			</c:if>
		</li>
		<li class="list-group-item">管理员：<a href="${ctx}/user/info?userId=${group.manager.id}">${group.manager.loginName}</a></li>
		<li class="list-group-item">
			<c:if test="${isMember}">
				已经是团队成员了^_^
			</c:if>
			<c:if test="${!isMember}">
				<a href="${ctx}/group/joinGroup?groupId=${group.id}">添加到团队</a>
			</c:if>
		</li>
	</ul>
<!-- 	<button class="btn" onclick="history.back()">返回</button> -->
</body>
</html>
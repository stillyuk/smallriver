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
	<div style="clear: both;"></div>
	<div class="btn-group pull-right">
		<a class="btn active" href="${ctx}/group/shareResource?groupId=${group.id}">共享资源</a>
		<a class="btn btn-primary" href="${ctx}/group/listGroupResource?groupId=${group.id}">查看群资源</a>
	</div>
	<div style="height: 40px;"></div>
	<ol class="breadcrumb">
		<li><a href="${ctx}/group">群组</a></li>
		<li class="active">${group.groupName}</li>
	</ol>
	<ul class="list-group">
		<li class="list-group-item">组名：${group.groupName}</li>
		<li class="list-group-item">创建时间：${group.createDate}</li>
		<li class="list-group-item">现在人数：${groupSize}<a href="${ctx}/group/allMembers?groupId=${group.id}">查看所有成员</a></li>
		<li class="list-group-item">管理员：<a href="${ctx}/user/info?userId=${group.manager.id}">${group.manager.loginName}</a></li>
		<li class="list-group-item">
			<c:if test="${isMember}">
				已经是群组成员了^_^
			</c:if>
			<c:if test="${!isMember}">
				<a href="${ctx}/group/joinGroup?groupId=${group.id}">添加到群组</a>
			</c:if>
		</li>
	</ul>
	<button class="btn" onclick="history.back()">返回</button>
</body>
</html>
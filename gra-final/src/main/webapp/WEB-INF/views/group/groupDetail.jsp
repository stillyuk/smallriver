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
	<ul class="nav nav-tabs">
		<li><a href="${ctx}">Home</a></li>
		<li><a href="${ctx}/file/upload">文件上传</a></li>
		<li><a href="${ctx}/file/download">文件下载</a></li>
		<li class="active"><a href="${ctx}/group">群组</a></li>
	</ul>
	<button class="btn" onclick="history.back()">返回</button>
	<ul class="list-group">
		<li class="list-group-item">组名：${group.groupName}</li>
		<li class="list-group-item">创建时间：${group.createDate}</li>
		<li class="list-group-item">现在人数：${groupSize}<a href="${ctx}/group/allMembers?groupId=${group.id}">查看所有成员</a></li>
		<li class="list-group-item">管理员：${group.manager.name}</li>
	</ul>
</body>
</html>
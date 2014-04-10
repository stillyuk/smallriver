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
		<li class="active"><a href="${ctx}/file/download">文件下载</a></li>
		<li><a href="${ctx}/group">群组</a></li>
	</ul>
	<button class="btn">返回</button>
	<ul class="list-group">
		<li class="list-group-item">文件名：${resource.name}</li>
		<li class="list-group-item">描述：${resource.remark}</li>
		<li class="list-group-item">上传日期：${resource.resourceDate}</li>
		<li class="list-group-item">下载次数：${resource.downloadTimes}</li>
		<li class="list-group-item"><a href="${ctx}/file/download/${resource.id}">点击下载</a></li>
	</ul>
</body>
</html>
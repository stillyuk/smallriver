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
		<li><a href="${ctx}/file/upload">文件上传</a></li>
		<li><a href="${ctx}/file/download">文件下载</a></li>
		<li class="active"><a href="${ctx}/group">群组</a></li>
	</ul>
	<div style="height: 50px;"></div>
	<ul class="list-group">
		<span class="label label-default">所有群列表</span>
		<c:forEach items="${groups}" var="group">
			<li class="list-group-item">
				<a href="${ctx}/group/joinGroup?groupId=${group.id}">申请加入该群</a>
				<div class="col-sm-4">
					组名：<a href="${ctx}/group/groupDetail?groupId=${group.id}">${group.groupName}</a>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
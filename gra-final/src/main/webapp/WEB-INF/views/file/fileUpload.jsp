<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}">Home</a></li>
		<li class="active"><a href="#">文件上传</a></li>
		<li><a href="${ctx}/file/download">文件下载</a></li>
		<li><a href="${ctx}/group">群组</a></li>
	</ul>
	<div class="alert alert-info">
		一共上传了${total}个文件
		<button class="close" data-dismiss="alert">×</button>
	</div>
	<c:if test="${not empty message}">
		<div class="alert alert-success">
			上传成功
			<button class="close" data-dismiss="alert">×</button>
		</div>
	</c:if>
	<div>
		<form method="POST" action="upload" enctype="multipart/form-data">
		<ul class="list-group">
			<li class="list-group-item">
				<input type="file" name="file" />
			</li>
			<li class="list-group-item">
				<input type="submit" value="提交" class="btn" />
			</li>
		</ul>
			
		</form>
	</div>
</body>
</html>
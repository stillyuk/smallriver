<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
<script type="text/javascript">
	function download(e) {
		$.ajax({
			type : "POST",
			url : "${ctx}/file/download/${resource.id}",
			data : {}
		});
		location.reload();
	}
	function deleteFile(e) {
		var choice = confirm("确定要删除文件吗？");
		if (!choice) {
			return;
		}
		$.ajax({
			asycn : false,
			type : "POST",
			url : "${ctx}/file/delete",
			data : {
				resourceId : "${resource.id}"
			}
		});
		location.href = "${ctx}/file/download";
	}
</script>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="${ctx}/file/download">文件下载</a></li>
		<li class="active">${resource.name}</li>
	</ol>
	<button class="btn" onclick="history.back()">返回</button>
	<ul class="list-group">
		<li class="list-group-item">文件名：${resource.name}</li>
		<li class="list-group-item">描述：${resource.discription}</li>
		<li class="list-group-item">上传日期：${resource.date}</li>
		<li class="list-group-item">下载次数：${resource.downloadTimes}</li>
		<li class="list-group-item">
			<a class="btn btn-primary" href="${ctx}/file/download/${resource.id}">点击下载</a>
			<button class="btn" onclick="deleteFile(this);">删除文件</button>
		</li>
	</ul>
</body>
</html>
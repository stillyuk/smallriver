<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详细信息</title>
<script src="${ctx}/static/fileupload/jsrender.js" type="text/javascript"></script>
<script type="text/x-jsrender" id="shareResourceTemplate">
    <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
		<span id="choiceProject">
			选择项目
		</span>
		<span class="caret"></span>
	</a>
	<input id="projectName" name="projectName" type="hidden" value="${project.projectName}" />
	<ul class="dropdown-menu">
		<c:forEach items="${projects}" var="project">
			<li onclick="select(this);"><a href="#">${project.projectName}</a></li>
		</c:forEach>
	</ul>
</script>
<script type="text/x-jsrender" id="submitTemplate">
	<button class="btn" onclick="submitRequest(this);">确定共享此文件</button>
</script>
<script type="text/javascript">
	function submitRequest() {
		$.ajax({
			type : "POST",
			url : "${ctx}/resource/share/${resource.id}",
			data : {
				projectName : $("#projectName").val()
			},
			success : function(data) {
				alert(data.message);
			},
			dataType : "json"
		});
// 		location.reload();
	}
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
	function shareResource() {
		var html  = $("#shareResourceTemplate").render();
		var submitButton  = $("#submitTemplate").render();
		$("#shareResource").append(html);
		$("#shareResource").append(submitButton);
		$("#shareButton").hide();
	}
	function select(t) {
		$("#choiceProject").text($(t).text());
		$("#projectName").val($(t).text());
	}
</script>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="${ctx}/file/download">文件列表</a></li>
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
		<li class="list-group-item">
			<button class="btn" onclick="deleteFile(this);">删除文件</button>
		</li>
		<li class="list-group-item" id="shareButton">
			<button class="btn" onclick="shareResource();">共享文件到项目</button>
		</li>
		<li class="list-group-item" id="shareResource">
		</li>
	</ul>
</body>
</html>
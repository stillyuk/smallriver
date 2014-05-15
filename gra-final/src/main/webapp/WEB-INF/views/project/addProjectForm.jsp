<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<title>用户注册</title>
<script type="text/javascript">
	function select(t) {
		$("#choiceGroup").text($(t).text());
		$("#groupName").val($(t).text());
	}
</script>
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="${ctx}/group">项目</a></li>
		<li class="active">新建</li>
	</ol>
	<form id="inputForm" action="${ctx}/project/create" method="post" class="form-horizontal">
		<div class="form-group">
			<label for="projectName" class="col-sm-2 control-label">项目名:</label>
			<div class="col-sm-3">
				<input type="text" id="projectName" name="projectName" class="form-control required" minlength="3"/>
			</div>
		</div>
		<div class="form-group">
			<label for="projectName" class="col-sm-2 control-label">所属团队:</label>
			<div class="col-sm-3">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="icon-user"></i>
					<span id="choiceGroup">
						<c:choose>
							<c:when test="${not empty group}">${group.groupName}</c:when>
							<c:otherwise>选择团队</c:otherwise>
						</c:choose>
					</span>
					<span class="caret"></span>
				</a>
				<input id="groupName" name="groupName" type="hidden" value="${group.groupName}" />
				<ul class="dropdown-menu">
					<c:forEach items="${ownGroups}" var="ownGroup">
						<li onclick="select(this);"><a href="#">${ownGroup.groupName}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<c:if test="${groupSize>0}">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
					<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
				</div>
			</div>
		</c:if>
		<c:if test="${groupSize eq 0}">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-3">
					<a href="${ctx}/group/create" class="btn btn-primary">没有拥有的团队，添加</a>
				</div>
			</div>
		</c:if>
	</form>
</body>
</html>

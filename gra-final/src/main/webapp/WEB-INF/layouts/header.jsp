<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script src="${ctx}/static/fileupload/jsrender.js" type="text/javascript"></script>
<script type="text/x-jsrender" id="groupTemplate">
	<li onclick="choiceGroup(this);"><a href="#">{{:groupName}}</a></li>
</script>
<script type="text/x-jsrender" id="projectTemplate">
	<li onclick="choiceProject(this);"><a href="#">{{:projectName}}</a></li>
</script>
<script type="text/javascript">
	var groups, projects;
	$(function() {
		$("#group").hide();
		$("#project").hide();
		$("#content").focus(function() {
			if ($("#groups>li").length == 0) {
				$.ajax({
					async : false,
					type : "POST",
					url : "${ctx}/group/getAllGroups",
					data : {},
					success : function(data) {
						groups = data;
					},
					dataType : "json"
				});
				$.ajax({
					async : false,
					type : "POST",
					url : "${ctx}/project/getAllProjects",
					data : {
						groupName : $("#searchGroupName").val()
					},
					success : function(data) {
						projects = data;
					},
					dataType : "json"
				});
				var groupHtml = $.templates("#groupTemplate").render(groups);
				var projectHtml = $.templates("#projectTemplate").render(projects);
				$("#groups").append(groupHtml);
				$("#projects").append(projectHtml);
			}
			$("#group").show(200);
			$("#project").show(200);
		});
		$("#content").blur(function() {
			if ($("#content").val() === "" && !$("#group").is(":hover") && !$("#project").is(":hover")) {
				$("#group").hide(400);
				$("#project").hide(400);
			}
		});
	});
	function choiceGroup(t) {
		$("#allGroups").text($(t).text());
		$("#searchGroupName").val($(t).text());
		$.ajax({
			async : false,
			type : "POST",
			url : "${ctx}/project/getAllProjects",
			data : {
				groupName : $("#searchGroupName").val()
			},
			success : function(data) {
				projects = data;
			},
			dataType : "json"
		});
		var projectHtml = $.templates("#projectTemplate").render(projects);
		$("#projects").empty().append(projectHtml);
	}
	function choiceProject(t) {
		$("#allProjects").text($(t).text());
		$("#searchProjectName").val($(t).text());
	}
</script>
<div id="header">
	<div id="title">
		<shiro:notAuthenticated>
			<h1><a href="${ctx}">浙江大学城市学院</a><small>&nbsp;资源管理系统</small>
		</shiro:notAuthenticated>
	    <shiro:user>
		    <nav class="navbar navbar-default">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="${ctx}">首页</a></li>
						<li><a href="${ctx}/friend">好友</a></li>
						<li><a href="${ctx}/file/upload">个人资源</a></li>
						<li><a href="${ctx}/group">团队</a></li>
						<li><a href="${ctx}/project">项目</a></li>
					</ul>
					<form class="navbar-form navbar-left" role="search" action="${ctx}/search">
						<div class="form-group">
							<input id="content" type="text" name="content" class="form-control" placeholder="Search">
						</div>
						<div id="group" class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
								<span id="allGroups">所在团队</span> <span class="caret"></span>
							</button>
							<input id="searchGroupName" name="searchGroupName" type="hidden" value="" />
							<ul id="groups" class="dropdown-menu pull-right">
							</ul>
						</div>
						<div id="project" class="btn-group">
							<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
								<span id="allProjects">所在项目 </span><span class="caret"></span>
							</button>
							<input id="searchProjectName" name="searchProjectName" type="hidden" value="" />
							<ul id="projects" class="dropdown-menu pull-right">
							</ul>
						</div>
						<button type="submit" class="btn btn-default">查询</button>
					</form>
					<span class="btn-group pull-right">
						<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
							<i class="icon-user"></i> <shiro:principal property="name"/>
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<shiro:hasRole name="admin">
								<li><a href="${ctx}/admin/user">Admin Users</a></li>
								<li class="divider"></li>
							</shiro:hasRole>
							<li><a href="${ctx}/profile">Edit Profile</a></li>
							<li><a href="${ctx}/logout">Logout</a></li>
						</ul>
					</span>
				</div>
			</nav>
		</shiro:user>
		</h1>
	</div>
</div>
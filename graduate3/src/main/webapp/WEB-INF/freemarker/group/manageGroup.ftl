<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理组</title>
<link rel="stylesheet" type="text/css" href="/css/desktop/group.css" />
<script type="text/javascript" src="/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="/js/desktop/registe.js"></script>
<script>
	function addGroupMember() {
		$("#add-button").after("<div><input id='username' type='text' /></div>");
		$("#username").after("<button onclick='checkUsername();'>查找</button>");
		$("#username").after("<span id='tip'></span>");
		$("#tip").after("<div id='userInfo'></div>");
	}

	function checkUsername() {
		$.get("/user/checkUsername", {username:$("#username").val()}, function(data) {
			if (data === "") {
				$("#tip").text("不存在此用户");
			} else {
				$("#tip").html("<a href='javascript:userInfo();'>查看用户信息</a>");
			}
		});
	}

	function userInfo() {
		$.ajax({
			url: "/user/userInfo",
			data: {
				username : $("#username").val()
			},
			success: function(data){
				$("#userInfo").append("用户名：" + data.message.username);
				$("#userInfo").append("邮箱：" + data.message.email);
			},
			dataType: "json"
		});
	}
</script>
</head>
<body>
	<div>
		<#if allGroup ??>
			<#list allGroup as group>
				<a href="/group/${group.groupName}">${group.groupName}</a>
				<button id="add-button" onclick="addGroupMember();">添加成员</button>
			</#list>
		</#if>
	</div>
</body>
</html>
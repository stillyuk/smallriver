<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script>
	function deleteFriend(e) {
		var choice = confirm("确定要删除此好友吗？");
		if (!choice) {
			return;
		}
		$.ajax({
			asycn : false,
			type : "POST",
			url : "${ctx}/user/deleteFriend",
			data : {
				deleteId : "${user.id}"
			}
		});
		location.href = "${ctx}/friend";
	}
</script>
</head>
<body>
	<c:if test="${not empty message}">
		<div class="alert alert-danger">
			<button class="close" data-dismiss="alert">×</button>
			${message}
		</div>
	</c:if>
	<ul class="list-group">
		<li class="list-group-item">登陆名：${user.loginName }</li>
		<li class="list-group-item">用户名称：${user.name }</li>
		<li class="list-group-item">注册时间：
			<fmt:formatDate value="${user.date}" pattern="yyyy年MM月dd日" /></li>
		<li class="list-group-item">
			<c:if test="${isFriend}">
				<a href="${ctx}/message/sendMessage?toId=${user.id}">发送消息</a>
			</c:if>
			<c:if test="${!isFriend}">
				<a href="${ctx}/user/add?toId=${user.id}">添加好友</a>
			</c:if>
		</li>
		<li class="list-group-item">
			<c:if test="${isFriend}">
				<button class="btn" onclick="deleteFriend(this);">删除好友</button>
			</c:if>
		</li>
	</ul>
</body>
</html>
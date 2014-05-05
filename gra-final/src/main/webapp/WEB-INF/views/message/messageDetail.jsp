<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript">
	function reply(e) {
		console.info();
		$.ajax({
			type : "POST",
			url : "${ctx}/friend/handler",
			data : {
				"choice" : $(e).val(),
				"toId" : "${message.from.id}",
				"messageId" : "${message.id}"
			}
		});
		location.reload();
	}
</script>
</head>
<body>
	<ul class="list-group">
		<li class="list-group-item">消息内容：${message.content}</li>
		<li class="list-group-item">发送用户：<a
			href="${ctx}/user/info?userId=${message.from.id}">${message.from.loginName}</a></li>
		<li class="list-group-item">发送日期： <fmt:formatDate
				value="${message.messageDate}" pattern="yyyy年MM月dd日" />
		</li>
		<c:if test="${message.isRead}">
			<div class="alert alert-danger">
				您已经处理过这条消息
			</div>
		</c:if>
		<c:if test="${!message.isRead}">
			<li class="list-group-item">
				<button class="btn" value="yes" onclick="reply(this)">同意</button>
				<button class="btn" value="no" onclick="reply(this)">拒绝</button>
			</li>
		</c:if>
	</ul>
</body>
</html>
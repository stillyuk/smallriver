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
	function replyAddGroup(e) {
		$.ajax({
			type : "POST",
			url : "${ctx}/group/handler",
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
				value="${message.date}" pattern="yyyy年MM月dd日" />
		</li>
		<c:if test="${message.isRead}">
			<div class="alert alert-danger">
				您已经处理过这条消息
			</div>
		</c:if>
		<c:if test="${!message.isRead}">
			<c:if test="${message.messageToType eq 'friend'}">
				<li class="list-group-item">
					<button class="btn" value="yes" onclick="reply(this)">同意添加好友</button>
					<button class="btn" value="no" onclick="reply(this)">拒绝</button>
				</li>
			</c:if>
			<c:if test="${message.messageToType eq 'group'}">
				<li class="list-group-item">
					<button class="btn" value="yes" onclick="replyAddGroup(this)">同意添加到群组</button>
					<button class="btn" value="no" onclick="replyAddGroup(this)">拒绝</button>
				</li>
			</c:if>
		</c:if>
	</ul>
</body>
</html>
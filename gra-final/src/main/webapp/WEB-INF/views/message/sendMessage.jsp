<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript">
	function test(t) {
		$("#choiceUser").text($(t).text());
		$("#toUser").val($(t).text());
	}
</script>
</head>
<body>
	<div style="float:left; width:200px;">
		<ul class="nav nav-pills nav-stacked">
	 		<li><a href="${ctx}/index">未处理的消息<span class="badge">${size}</span></a>
			<li><a href="${ctx}/message/allSendMessages">所有发送的消息</a></li>
			<li><a href="${ctx}/message/allReceiveMessages">所有接受的消息</a></li>
			<li class="active"><a href="${ctx}/message/sendMessage">发送消息</a></li>
		</ul>
	</div>
	<div style="float:right; width:600px;">
		<form id="loginForm" action="${ctx}/message/doSendMessage" method="post" class="form-horizontal" role="form">
			<c:if test="${not empty message}">
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-4 alert alert-danger">
						<button class="close" data-dismiss="alert">×</button>
						${message}
					</div>
				</div>
			</c:if>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					发送到：
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span id="choiceUser">选择用户</span>
						<span class="caret"></span>
					</a>
					<input id="toUser" name="toUser" type="hidden" value="" />
					<ul class="dropdown-menu">
						<c:forEach items="${friends}" var="friend">
							<li onclick="test(this);"><a href="#">${friend.to.loginName}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<input id="message" name="message" type="text" class="form-control required" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-4">
					<input type="submit" class="btn btn-primary" value="发送" />
				</div>
			</div>
		</form>
	</div>
	<div style="clear:both;"></div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>share</title>
</head>
<body>
	<form method="POST" action="${ctx}/group/saveResource" enctype="multipart/form-data">
		<input type="hidden" name="groupId" value="${groupId}" />
		<ul class="list-group">
			<li class="list-group-item">
				<input type="file" name="file" />
			</li>
			<li class="list-group-item">
				<input type="submit" value="共享" class="btn" />
			</li>
		</ul>
	</form>
</body>
</html>
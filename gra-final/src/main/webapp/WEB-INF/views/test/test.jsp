<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	$(function() {
		$("#loginForm").validate();
	});
</script>
</head>
<body>
	<div class="row">

		<div class="col-xs-2">

			<input type="text" class="form-control" placeholder=".col-xs-2">

		</div>

		<div class="col-xs-3">

			<input type="text" class="form-control" placeholder=".col-xs-3">

		</div>

		<div class="col-xs-4">

			<input type="text" class="form-control" placeholder=".col-xs-4">

		</div>

	</div>
</body>
</html>
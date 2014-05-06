<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户管理</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>登录名</th><th>用户名</th><th>注册时间<th>管理</th></tr></thead>
		<tbody>
		<c:set var="i" value="1"/>
		<c:forEach items="${users.content}" var="user">
			<c:set var="i" value="${i+1}"/>
			<tr>
				<td><a href="${ctx}/user/info/?userId=${user.id}">${user.loginName}</a></td>
				<td>${user.name}</td>
				<td>
					<fmt:formatDate value="${user.registerDate}" pattern="yyyy年MM月dd日 " />
				</td>
				<td><a href="${ctx}/admin/user/delete/${user.id}">删除</a></td>
			</tr>
		</c:forEach>
		<c:forEach begin="${i}" end="3">
			<tr><td>...</td><td>...</td><td>...</td><td>...</td></tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="col-md-4"></div>
	<ul class="pagination">
		<c:if test="${users.number ne 0}">
			<li><a href="${ctx}/admin/user?page=${users.number}">&laquo;</a></li>
		</c:if>
		<c:if test="${users.number eq 0}">
			<li class="disabled"><a href="#">&laquo;</a></li>
		</c:if>
		<c:forEach var="i" begin="0" end="${users.totalPages-1}">
			<c:if test="${i eq users.number}">
				<li class="active"><a href="${ctx}/admin/user?page=${i+1}">${i+1}</a></li>
			</c:if>
			<c:if test="${i ne users.number}">
				<li><a href="${ctx}/admin/user?page=${i+1}">${i+1}</a></li>
			</c:if>
		</c:forEach>
		<c:if test="${users.number ne users.totalPages-1}">
			<li><a href="${ctx}/admin/user?page=${users.number+2}">&raquo;</a></li>
		</c:if>
		<c:if test="${users.number eq users.totalPages-1}">
			<li class="disabled"><a href="#">&raquo;</a></li>
		</c:if>
	</ul>
</body>
</html>
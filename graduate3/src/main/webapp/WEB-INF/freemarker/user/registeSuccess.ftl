<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="/css/desktop/login.css" />
<script type="text/javascript" src="/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="/js/desktop/registe.js"></script>
<style>
	.file-box {
		position: relative;
		width: 370px;
		border: 1px solid #999;
		padding: 10px 10px;
		margin: 10px 10px;
	}
	.file {
		position: absolute;
		width: 285px;
		top: 15px;
		left: 10px;
		opacity: 0;
	}
	.text {
		position: relative;
		top: 5px;
		width: 200px;
	}
	.btn {
		position: relative;
		width: 75px;
		height: 26px;
		top: 5px;
		font-size: 16px;
	}
	.registeInfo {
		border: 1px dotted #ccc;
	}
</style>
</head>
<body>
	<div>用户${user.username}注册成功</div>
	<div>邮件已经发送到您的邮箱${user.email},登陆邮箱激活帐户</div>
	<div class="">您的注册信息为：
		<div>用户名：${user.username}</div>
		<div>密码：${user.password}</div>
		<div>邮箱：${user.email}</div>
	</div>
	<div class="file-box">
		<form>
			<input type="text" class="text" id="text" />
			<input type="button" value="浏览" class="btn" />
			<input type="file" class="file" onchange="document.getElementById('text').value=this.value" />
			<input type="submit" value="提交" class="btn" />
		</form>
	</div>
</body>
</html>
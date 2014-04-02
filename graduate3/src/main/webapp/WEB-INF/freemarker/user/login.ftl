<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="/css/desktop/login.css" />
</head>
<body>
	<div class="center-form">
		<form action="signIn" method="POST">
			<div class="form-head">登陆</div>
			<div class="form-tips">${tip}</div>
			<div class="form-body">
				用户名：<input class="form-input" type="text" name="username" />
				密码：<input class="form-input" type="password" name="password" />
				<input class="form-button" type="submit" value="登陆" />
				<a href="registe">免费注册</a>
			</div>
		</form>
	</div>
</body>
</html>
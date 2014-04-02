<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="/css/desktop/login.css" />
<script type="text/javascript" src="/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="/js/desktop/registe.js"></script>
</head>
<body>
	<div class="center-form">
		<form action="signUp" method="POST">
			<div class="form-head">注册</div>
			<div class="form-tips"></div>
			<div class="form-body">
				用户名：<span id="tip"></span><input class="form-input" type="text" id="username" name="username" />
				密码：<input class="form-input" type="password" id="password" name="password" />
				手机/邮箱：<input class="form-input" type="text" name="email" />
				验证码<input class="form-input" type="text" />
				<input class="form-button" type="submit" value="注册" id="registe" />
				<a href="login">点击登陆</a>
			</div>
		</form>
	</div>
</body>
</html>
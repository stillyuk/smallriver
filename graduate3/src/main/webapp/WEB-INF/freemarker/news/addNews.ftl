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
		<form action="doAddNews" method="POST">
			<div class="form-head">添加新闻</div>
			<div class="form-tips"></div>
			<div class="form-body">
				标题：<span id="tip"></span><input class="form-input" type="text" id="title" name="title" />
				内容：<input class="form-input" type="text" id="news" name="news" />
				top：<input class="form-input" type="number" id="top" name="top" />
				验证码：<input class="form-input" type="text" />
				<input class="form-button" type="submit" value="添加" />
			</div>
		</form>
	</div>
</body>
</html>
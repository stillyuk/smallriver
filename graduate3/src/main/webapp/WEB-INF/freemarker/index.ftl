<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/desktop/global.css" />
<link rel="stylesheet" type="text/css" href="/css/desktop/head.css" />
<link rel="stylesheet" type="text/css" href="/css/desktop/main.css" />
<script type="text/javascript" src="/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="/js/desktop/common.js"></script>
<script type="text/javascript" src="/js/desktop/index.js"></script>
</head>
<body class="body">
	<div class="nar">
		<div class="head">
			<div class="logo"></div>
			<div class="btn"><a href="/index"><i>首页</i></a></div>
			<div class="btn"><a href="/publicResource"><i>公共资源区</i></a></div>
			<div class="btn"><a href=""><i>待定</i></a></div>
			<div class="user">
				<div class="setting">
					<a class="name" href="">tkggycb</a>
				</div>
				<div class="setting">
					<i><a class="tab" href="#">
							<span id="setting" class="ico">设置</span>
					</a></i>
				</div>
			</div>
		</div>
	</div>
	<div class="reigste-or-login">
		<div class="info_list">
			<div class="email">
				<input type="text" name="username" id="username" data-info="输入邮箱地址" />
			</div>
		</div>
		<div class="info_list">
			<div class="password">
				<input type="password" name="password" id="password" data-info="输入密码" />
			</div>
		</div>
		<div class="fast_registe">
			<div class="submit_btn"><a  onclick="registe()">快速注册</a></div>
		</div>
		<div class="go_login">已有账号，<a href="/user/login">直接登录>></a></div>
	</div>
	<div class="main">
		<div class="main_left"  id="main_left">
			<div class="left_list" id="news"><a href="">新闻</a></div>
			<div class="left_list" id="public"><a href="">公共资源区</a></div>
			<div class="left_list"><a href="">其他</a></div>
		</div>
		<div class="center">
			<div id="news_content"></div>
			<div id="public_content"></div>
			<div id="other_content"></div>
		</div>
	</div>
</body>
</html>
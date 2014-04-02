<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传文件</title>
<link rel="stylesheet" type="text/css" href="/css/desktop/css.css" />
<style>
	.file-box {
		position: relative;
		width: 370px;
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
	<div class="head">
		<div class="box">
			<div class="topbar">
				<div class="topbarl">文件管理系统</div>
				<div class="topbarr">
					<ul>
						<li>登录|</li>
						<li>注册|</li>
						<li>待定</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<div class="nar">
		<div class="box">
			<div class="logo">
				<img alt="aa" src="/img/logo.gif">
			</div>
			<div class="narr">
				<ul>
					<li><a href="/file/upload" class="hover">文件上传</a></li>
					<li><a href="/file/download">文件下载</a></li>
					<li><a href="">创建组</a></li>
					<li><a href="">删除组</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="main">
		<div class="box">
			<div class="file-box">
				<form method="POST" action="doUpload" enctype="multipart/form-data">
					<input type="text" class="text" id="text" />
					<input type="button" value="浏览" class="btn" />
					<input type="file" name="file" class="file" onchange="document.getElementById('text').value=this.value" />
					<input type="submit" value="提交" class="btn" />
				</form>
			</div>
		</div>
	</div>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" type="text/css" href="/css/desktop/css.css" />
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
					<li><a href="/file/upload">文件上传</a></li>
					<li><a href="/file/download" class="hover">文件下载</a></li>
					<li><a href="">创建组</a></li>
					<li><a href="">删除组</a></li>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="main">
		<div class="box">
			<div class="file_list_tip">文件列表</div>
			<div>
				<#if allFiles ??>
					<#list allFiles as file>
						<div class="file_list">
							<div class="file_log"></div>
							<a href="/file/fileDetail?fileName=${file.name}">${file.name}</a>
						</div>
					</#list>
				</#if>
			</div>
		<div>
	</div>
	<div class="foot">
		<div class="box"></div>
	</div>
</body>
</html>
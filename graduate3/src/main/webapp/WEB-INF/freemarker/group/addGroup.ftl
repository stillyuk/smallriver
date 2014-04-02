<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加组</title>
<link rel="stylesheet" type="text/css" href="/css/desktop/group.css" />
<script type="text/javascript" src="/js/jquery-2.1.0.js"></script>
<script type="text/javascript" src="/js/desktop/registe.js"></script>
</head>
<body>
	<div class="center-form">
		<form action="doAddGroup" method="POST">
			<div class="form-head">添加组</div>
			<div class="form-tips"></div>
			<div class="form-body">
				组名：<span id="tip"></span><input class="form-input" type="text" id="groupName" name="groupName" />
				<input class="form-button" type="submit" value="添加" />
			</div>
		</form>
	</div>
</body>
</html>
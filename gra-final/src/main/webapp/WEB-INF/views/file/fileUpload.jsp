<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<ul class="nav nav-pills">
		<li><a href="#">Home</a></li>
		<li class="active"><a href="#">文件上传</a></li>
		<li><a href="#">文件下载</a></li>
	</ul>
	<div>
		<form method="POST" action="upload" enctype="multipart/form-data">
			<input type="file" name="file" />
			<input type="submit" value="提交" />
		</form>
	</div>
</body>
</html>
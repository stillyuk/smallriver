<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<#if allFiles ??>
		<#list allFiles as file>
			<a href="download?fileName=${file.name}">${file.name}</a>
		</#list>
	</#if>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>share</title>
<link rel="stylesheet" href="${ctx}/static/styles/jquery.fileupload.css" />
</head>
<body>
	<ol class="breadcrumb">
		<li><a href="${ctx}/group">团队</a></li>
		<li><a href="${ctx}/group/groupDetail?groupId=${project.id}">${project.projectName}</a></li>
		<li class="active">共享团队资源</li>
	</ol>
	<c:if test="${not empty message}">
		<div class="alert alert-success">
			${message}
			<button class="close" data-dismiss="alert">×</button>
		</div>
	</c:if>
	<div class="container">
	    <form id="fileupload" action="#" method="POST" enctype="multipart/form-data">
	        <div class="row fileupload-buttonbar">
	            <div class="col-lg-7">
	                <span class="btn btn-success fileinput-button">
	                    <i class="glyphicon glyphicon-plus"></i>
	                    <span>Add files...</span>
	                    <input type="file" name="file" multiple>
	                </span>
	                <button type="submit" class="btn btn-primary start">
	                    <i class="glyphicon glyphicon-upload"></i>
	                    <span>Start upload</span>
	                </button>
	                <button type="reset" class="btn btn-warning cancel">
	                    <i class="glyphicon glyphicon-ban-circle"></i>
	                    <span>Cancel upload</span>
	                </button>
	                <input type="checkbox" class="toggle">
	            </div>
	            <div class="col-lg-5 fileupload-progress fade">
	                <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
	                    <div class="progress-bar progress-bar-success" style="width:0%;"></div>
	                </div>
	                <div class="progress-extended">&nbsp;</div>
	            </div>
	        </div>
	        <table role="presentation" class="table table-striped"><tbody class="files"></tbody></table>
	    </form>
	    <br>
	</div>
<script id="template-upload" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
        <td>
            <span class="preview"></span>
        </td>
        <td>
            <p class="name">{%=file.name%}</p>
            <strong class="error text-danger"></strong>
        </td>
        <td>
            <p class="size">Processing...</p>
            <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="progress-bar progress-bar-success" style="width:0%;"></div></div>
        </td>
        <td>
            {% if (!i && !o.options.autoUpload) { %}
                <button class="btn btn-primary start" disabled>
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Start</span>
                </button>
            {% } %}
            {% if (!i) { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
<script id="template-download" type="text/x-tmpl">
{% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-download fade">
        <td>
            <span class="preview">
                {% if (file.thumbnailUrl) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" data-gallery><img src="{%=file.thumbnailUrl%}"></a>
                {% } %}
            </span>
        </td>
        <td>
            <p class="name">
                {% if (file.url) { %}
                    <a href="{%=file.url%}" title="{%=file.name%}" download="{%=file.name%}" {%=file.thumbnailUrl?'data-gallery':''%}>{%=file.name%}</a>
                {% } else { %}
                    <span>{%=file.name%}</span>
                {% } %}
            </p>
			{% if (file.error) { %}
                <div><span class="label label-danger">Error</span> {%=file.error%}</div>
            {% } %}
        </td>
        <td>
            <span class="size">{%=o.formatFileSize(file.size)%}</span>
        </td>
        <td>
            {% if (file.deleteUrl) { %}
                <button class="btn btn-danger delete" data-type="{%=file.deleteType%}" data-url="{%=file.deleteUrl%}"{% if (file.deleteWithCredentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Delete</span>
                </button>
                <input type="checkbox" name="delete" value="1" class="toggle">
            {% } else { %}
                <button class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancel</span>
                </button>
            {% } %}
        </td>
    </tr>
{% } %}
</script>
<%-- 	<script src="${ctx}/static/fileupload/jsrender.js" type="text/javascript"></script> --%>
	<script src="${ctx}/static/fileupload/jquery.ui.widget.js" type="text/javascript"></script>
	<script src="${ctx}/static/fileupload/load-image.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/fileupload/tmpl.js"></script>
	<script src="${ctx}/static/fileupload/jquery.iframe-transport.js" type="text/javascript"></script>
	<script src="${ctx}/static/fileupload/jquery.fileupload.js" type="text/javascript"></script>
	<script src="${ctx}/static/fileupload/jquery.fileupload-process.js" type="text/javascript"></script>
	<script src="${ctx}/static/fileupload/jquery.fileupload-image.js" type="text/javascript"></script>
	<script src="${ctx}/static/fileupload/jquery.fileupload-ui.js" type="text/javascript"></script>
	<script type="text/javascript">
		$('#fileupload').fileupload({
			url : "${ctx}/project/saveResource?projectId=${project.id}",
			done : function(e, result) {
				alert(result.result.message);
			}
		});
	</script>
</body>
</html>

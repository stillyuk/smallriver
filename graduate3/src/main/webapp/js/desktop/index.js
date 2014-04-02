$(function() {
	$("[id$='content']").hide();
	$("#setting").mouseenter(function() {
		$("#setting").after("<div id='show_setting'>a</div>");
		$("#show_setting").css("position", "absolute").css("top", "41px").css("left", "800px")
			.css("width", "100").css("height", "200").css("background", "#ccc");
	});
	$("#setting").mouseleave(function() {
		$("#show_setting").remove();
	});
	$.each($("#main_left>*"), function(i, v) {
		v = $(v);
		v.click(function() {
			$("#main_left>*").css("background", "grey");
			v.css("background", "white");
			$("#public_content>*").remove();
			if (v.attr("id") === "public") {
				$("#public_content").show();
				$.ajax({
					url : "/file/publicFiles",
					success: function(publicFiles) {
						$.each(publicFiles, function(i, ele) {
							$("#public_content").append("<div class='files'><div class='file_list'><a href=''>"
								+ ele.name + "</a></div><div class='download'><a href='/file/download'>点击下载文件</a></div></div>");
						});
					},
					dataType: "json"
				});
			} else if (v.attr("id") === "news") {
				
			}
			return false;
		});
	});
});

function registe() {
	$.ajax({
		url : "/user/doRegiste",
		type : "post",
		data : {
			"username" : $("#username").val(),
			"password" : $("#password").val()
		},
		success : function(info) {
			alert(info);
		},
		dataType: "text"
	});
}
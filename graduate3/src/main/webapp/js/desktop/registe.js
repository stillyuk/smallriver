$(function() {
	$("#username").blur(function() {
		$.ajax({
			url : "checkUsername",
			data : {
				username : $("#username").val()
			},
			success : function(tip) {
				$("#tip").text(tip.message).css("color", "red");
				if (tip != "") {
					$("#registe").attr("disabled", "true");
				} else {
					$("#registe").removeAttr("disabled");
				}
			},
			dataType : "json"
		});
	});
});

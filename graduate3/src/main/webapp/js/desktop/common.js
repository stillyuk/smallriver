$(function() {
	var a = $("input[data-info]");
	a.each(function(i, b) {
		var k = $("#" + $(b).attr("id"));
		var v = $(b).data("info");
		var id= "tip" + i;
		k.before("<div id=" + id + ">" + v + "</div>");
		$("#" + id).css("position", "absolute").css("top", k.position().top)
			.css("left", k.position().left).css("width", k.width()).css("height", k.height())
			.css("line-height", k.height() + "px").attr("class", "input_tip");
		k.focus(function() {
			$("#" + id).html("");
		});
		k.blur(function() {
			if (k.val() === "") {
				$("#" + id).html(v);
			}
		});
	});
});
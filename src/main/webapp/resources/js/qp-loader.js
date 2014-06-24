window.onload = function() {
	$("#qp_text").text("");
	$("#qp_link").attr("href", "#");
	$("#qp_badge").text("");

	var state = [], values = [];
	$(".tingo-question")
			.map(
					function(index, element) {
						// alert(index + " " + $(element).attr("response") + " "
						// + $(element).attr("qid"));
						state[index] = false;
						values[index] = $(element).attr("response");

						var link = $("a:first", element);

						link
								.click(function() {
									state[index] = !state[index];

									var html = state[index] ? "<span class=\"glyphicon glyphicon-plus\"></span>"
											: "<span class=\"glyphicon glyphicon-remove\"></span>";

									$(".panel-footer:last", element).html(html);
									
									return false;
								});
					});

	$(".tingo-submit").map(
			function(index, element) {
				$(element).click(
						function() {
							var list = [];

							state.forEach(function(element, index) {
								if (element) {
									list.push(values[index]);
								}
							});

							$.ajax({
								type : "POST",
								url : contextPath + "/question/ajax/"
										+ groupindex + "/" + questionindex,
								data : "results=" + list,

								success : function(response) {
									var mc = "alert alert-dismissable";

									switch (response.type) {
									case "INCORRECT":
										mc += " alert-danger";
										break;
									case "PARTLY":
										mc += " alert-warning";
										break;
									case "CORRECT":
										mc += " alert-success";
										break;
									default:
										console.log("Unknown response type: "
												+ response.type);
									}

									var info = $('<div/>', {
										'class' : mc,
										'text' : response.message
									});

									$('<button/>', {
										'type' : 'button',
										'class' : 'close',
										'data-dismiss' : "alert",
										'aria-hidden' : "true",
										'html' : "&times;"
									}).appendTo(info);

									$("#Tingo-Feedback").html("").append(info);
									$("#badge-" + questionindex).text(response.type);
								},
								error : function(e) {
									alert("error: " + e);
								}
							});
						});
			});
};

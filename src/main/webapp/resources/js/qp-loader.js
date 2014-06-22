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
								});
					});

	$(".tingo-submit").map(function(index, element) {
		$(element).click(function() {
			var list = [];
			
			state.forEach(function(element, index) {
				if(element) {
					list.push(values[index]);
					console.log("here  : " + index + "/" + element);
				}
			});
			
			$.ajax({
				type : "POST",
				url : contextPath + "/question/ajax/" + groupindex + "/" + questionindex,
				data : "results=" + list,

				success : function(response) {

					// $( ".result" ).html( data );
					// console.log(data);

				},
				error : function(e) {
					alert("error: " + e);
				}
			});
		});
	});
};

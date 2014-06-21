window.onload = function() {
	$("#qp_text").text("");
	$("#qp_link").attr("href", "#");
	$("#qp_badge").text("");

	var list = [];
	
	$.ajax({
		type : "POST",
		url : contextPath + "/question/ajax/0/0",
		data : "results=" + list,
		
		success : function(response) {

			// $( ".result" ).html( data );
			// console.log(data);

		},
		error : function(e) {
			alert("error: " + e);
		}
	});
};
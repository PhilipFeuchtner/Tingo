window.onload = function() {
	$("#qp_text").text("");
	$("#qp_link").attr("href", "#");
	$("#qp_badge").text("");

	var list = [ "a a", "b,b", "c", "d" ];

	alert("results=" + list);
	
	$.ajax({
		type : "POST",
		url : contextPath + "/question/ajax/0/1",
		data : "results=" + list,
		
		success : function(response) {

			// $( ".result" ).html( data );
			// console.log(data);

			alert("success: " + response);
		},
		error : function(e) {
			alert("error: " + e);
		}
	});
};
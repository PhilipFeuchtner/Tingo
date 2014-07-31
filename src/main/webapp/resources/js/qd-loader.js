window.onload = function() {
	$("#qd_text").text("");
	$("#qd_link").attr("href", "#");
	$("#qd_badge").text("");

	var g = Snap("#svg-mansion");

	g.attr({
		viewBox : [ 0, 0, 600, 200 ]
	});

	Snap.load("resources/img/demo.svg", function(f) {

		var top = g.g(), gr = f.select("#svg3134");

		top.add(gr);

		// ----------------------------- //
		// demo: annimation

		var del = gr.select("#attic_toolbox"),clone = del.clone();
		
		var myMatrix = new Snap.Matrix();
		myMatrix.scale(0.25,0.25);		// play with scaling before and after the rotate 
		myMatrix.translate(1800,1800);  
		myMatrix.translate(500,0);  

		clone.animate({ transform: myMatrix },3000);
		del.animate({opacity : 0.2}, 1000);

		// ----------------------------- //

		// $.getJSON("mansion/ajax", function(data) {
		// $( ".result" ).html( data );
		// console.log(data);

		// $.each(svgids, function(index) {
		svgids.forEach(function(id, index) {
			// var node = data[index], state = node.state, svgel = gr
			// .select("#" + node.svgid), item = $("#list-"
			// + node.svgid);

			var svgel = gr.select("#" + id), item = $("#list-" + id);

			// if (state.correct == "CORRECT") {
			// svgel.animate({
			// opacity : 0.2
			// }, 1000);
			//					
			// var t = new Snap.Matrix(), clone = svgel.clone();
			// t.scale(0.5);
			// t.translate(500, 400);
			//					
			// // t.rotate(20, 100, 100);
			//					
			// clone.transform(t);
			//
			// item.addClass('list-group-item-success');
			// } else {
			var clickListener = function() {
				return function() {
					$("#qd_form").attr("action",
							"mansion/questiondefault/" + index);

					$(".last-active").removeClass("active").removeClass(
							"last-active");
					item.addClass("last-active");
					item.addClass("active");
				};
			};

			if (svgel != null) {
				svgel.click(clickListener());
				svgel.attr({
					"cursor" : "pointer"
				});

				// item.click(clickListener());
			}
			// }
		});
		// });

	});
};
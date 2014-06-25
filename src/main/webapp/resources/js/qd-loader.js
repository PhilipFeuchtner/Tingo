window.onload = function() {
	$("#qd_text").text("");
	$("#qd_link").attr("href", "#");
	$("#qd_badge").text("");

	var g = Snap("#svg-mansion");

	g.attr({
		viewBox : [ 0, 0, 600, 200 ]
	});

	Snap.load("resources/img/simple.svg", function(f) {

		var top = g.g(), gr = f.select("#simple");

		top.add(gr);

		// ----------------------------- //

		$.getJSON("mansion/ajax", function(data) {
			// $( ".result" ).html( data );
			// console.log(data);

			$.each(data, function(index) {
				var node = data[index], state = node.state, svgel = gr
						.select("#" + node.svgid), item = $("#list-"
						+ node.svgid);

				if (state.correct == "CORRECT") {
					svgel.animate({
						opacity : 0.2
					}, 1000);
					
					var t = new Snap.Matrix(), clone = svgel.clone();
					t.scale(0.5);
					t.translate(500, 400);
					
					// t.rotate(20, 100, 100);
					
					clone.transform(t);

					item.addClass('list-group-item-success');
				} else {
					var clickListener = function() {
						return function() {
							$("#qd_text").text(node.display);
							$("#qd_link").attr("href",
									"mansion/questiongroup/" + index);
							$("#qd_badge").text(
									state.state + "/" + state.correct + "/"
											+ state.score);
							
							$(".last-active").removeClass("active").removeClass("last-active");
							item.addClass("last-active");
							item.addClass("active");
						};
					};

					svgel.click(clickListener());
					svgel.attr({
						"cursor" : "pointer"
					});

					item.click(clickListener());
				}
			});
		});

	});
};
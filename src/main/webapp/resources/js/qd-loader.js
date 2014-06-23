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

					item.addClass('list-group-item-success');
				} else {
					svgel.click(function() {

						$("#qd_text").text(node.display);
						$("#qd_link").attr("href",
								"mansion/questiongroup/" + index);
						$("#qd_badge").text(
								state.state + "/" + state.correct + "/"
										+ state.score);
					});

					svgel.attr({
						"cursor" : "pointer"
					});

					item.click(function() {

						$("#qd_text").text(node.display);
						$("#qd_link").attr("href",
								"mansion/questiongroup/" + index);
						$("#qd_badge").text(
								state.state + "/" + state.correct + "/"
										+ state.score);
					});
				}
			});
		});

	});
};
var mansionListener = function(node, index) {
	$("#qd_text").text(node["display"]);
	$("#qd_link").attr("href", "mansion/questiongroup/" + index);
};

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

			jQuery.each(data, function(index) {
				var node = data[index],

				svgel = gr.select("#" + node["svgid"]);

				if (node["correct"]) {
					svgel.animate({opacity: 0.2}, 1000);
				} else {
					svgel.click(function() {
						// mansionListener(node, index);
						$("#qd_text").text(node["display"]);
						$("#qd_link").attr("href",
								"mansion/questiongroup/" + index);
					});

					svgel.attr({
						"cursor" : "pointer"
					});
				}
			});
		});

	});
};
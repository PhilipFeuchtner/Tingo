window.onload = function() {
	var g = Snap();

	g.attr({
		viewBox : [ 0, 0, 800, 600 ]
	});

	Snap.load("resources/img/pattern.svg", function(f) {

		var top = g.g(), gr = f.select("#svg3343");

		top.add(gr);
	});
};
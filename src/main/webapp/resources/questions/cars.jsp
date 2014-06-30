<%@ taglib tagdir="/WEB-INF/tags" prefix="tingo"%>

<h1>Question</h1>
<p>Where is the bus?</p>

<div class="row">
	<div class="col-sm-6 col-md-4">
		<tingo:multipleChoice questionid="q1" response="A" style="thumbnail">
			<img src="${pageContext.request.contextPath}/resources/img/car1.png"
				alt="alt text" title="Car 1" />
			<span class="caption">Car 1</span>
		</tingo:multipleChoice>
	</div>

	<div class="col-sm-6 col-md-4">
		<tingo:multipleChoice questionid="q1" response="B" style="thumbnail">
			<img src="${pageContext.request.contextPath}/resources/img/car2.png"
				alt="alt text" title="Car 2" />
			<span class="caption">Car 2</span>
		</tingo:multipleChoice>
	</div>
</div>

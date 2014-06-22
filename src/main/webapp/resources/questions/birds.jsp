<%@ taglib prefix="tingo" uri="/WEB-INF/tingotags.tld"%>

<h1>Question</h1>
<p>What is my favorite bird?</p>

<div class="panel panel-default">
	<div class="panel-heading">Bird 1</div>
	<div class="panel-body">
		<tingo:multipleChoice questionid="q0" response="A">
			<img src="${pageContext.request.contextPath}/resources/img/bird1.png"
				alt="alt text" title="Bird 1" />
		</tingo:multipleChoice>
	</div>

</div>
<div class="panel panel-default active">
	<div class="panel-heading">Bird 2</div>
	<div class="panel-body">
		<tingo:multipleChoice questionid="q0" response="B">
			<img src="${pageContext.request.contextPath}/resources/img/bird2.png"
				alt="alt text" title="Bird 2" />
		</tingo:multipleChoice>
	</div>
</div>
<div class="panel panel-default">
	<div class="panel-heading">B1rd 3</div>
	<div class="panel-body">
		<tingo:multipleChoice questionid="q0" response="C">
			<img src="${pageContext.request.contextPath}/resources/img/bird3.png"
				alt="alt text" title="Bird 3" />
		</tingo:multipleChoice>
	</div>
</div>

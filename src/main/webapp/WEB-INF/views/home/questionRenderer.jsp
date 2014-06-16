<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<h2>QuestionRenderer</h2>
<p>
	Hello
	<security:authentication property="principal.username" />
	!
</p>

<div class="modal-body row">
	<div class="col-md-4">
		<div class="list-group">
			<c:forEach var="q" items="${qg.questions}">
				<a href="#" class="list-group-item"> <c:out value="${q.display}" />
				</a>
			</c:forEach>
		</div>
	</div>
	<div class="col-md-8">
		<div class="panel panel-default">
			<div class="panel-body">
				<%@include file="/resources/questions/birds.qs"%>
			</div>
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a id="qd_link" href="/tingo/mansion/ajax">
						<span id="qd_badge" class="badge pull-right">qd_badge</span>
						<button id="qd_submit" type="button" class="btn btn-default">Submit</button>
						<span id="qd_text">qd_text</span>
				</a></li>
			</ul>
		</div>

	</div>
</div>



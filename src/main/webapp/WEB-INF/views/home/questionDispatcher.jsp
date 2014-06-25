<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!-- <h2>QuestionDispatcher</h2> -->

<div class="modal-body row">
	<div class="col-md-3">
		<div class="list-group">
			<c:forEach var="q" items="${questiongroups}" varStatus="status">
				<a href="#" class="list-group-item tingo-menu" id="list-${q.svgid}">
					<c:out value="${q.display}" />
				</a>
			</c:forEach>
		</div>
	</div>

	<div class="col-md-9">
		<svg id="svg-mansion"></svg>
	</div>
</div>

<div class="well">
	<form id="qd_form" action="mansion/ajax">
		<button id="qd_submit" type="submit" class="btn btn-default">
			Weiter &rarr;</button>
	</form>
</div>

<script src="<c:url value="/resources/js/snap.svg-min.js" />"></script>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	// console.log(contextPath);
</script>
<script src="<c:url value="/resources/js/qd-loader.js" />"></script>
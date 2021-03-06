<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!-- <h2>QuestionDispatcher</h2> -->

<c:set var="showDemo" value="false" />

<div class="modal-body row">
	<div class="col-md-3">
		<div class="list-group">
		
			<c:forEach var="q" items="${repo.sectionlist}" varStatus="status">
			
				<c:url var="link" value="/mansion/questiondefault/${status.index}" />
				<a href="${link}" class="list-group-item tingo-menu"
					id="list-${q.svgid}"> <c:out value="${q.title}" />
				</a>

				<c:choose>
					<c:when test="${status.first}">
						<c:set var="svgids" value="${q.svgid}" />
					</c:when>
					<c:otherwise>
						<c:set var="svgids" value="${svgids} ${q.svgid}" />
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${q.state.solved == 'CORRECT'}">
								<c:set var="showDemo" value="true" />
					</c:when>
				</c:choose>

			</c:forEach>
		</div>
	</div>

	<div class="col-md-9">
		<svg id="svg-mansion"></svg>
		<svg id="svg-demo"></svg>
	</div>
</div>

<div class="well">
	<form id="qd_form" action="mansion/ajax" method="get">
<!-- 		<button id="qd_submit" type="submit" class="btn btn-default"> -->
<!-- 			Weiter &rarr;</button> -->
			 <button id="qd_submit" type="submit" class="btn btn-primary btn-lg">Continue &rarr;</button>
	</form>
</div>

<script src="<c:url value="/resources/js/snap.svg-min.js" />"></script>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}", svgids_string = "${svgids}", svgids = svgids_string
			.split(" "), showDemo = ${showDemo};
	// console.log(contextPath);
</script>
<script src="<c:url value="/resources/js/qd-loader.js" />"></script>
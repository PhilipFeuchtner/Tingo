<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>


<div class="list-group">
	<c:forEach var="q" items="${qg.questions}" varStatus="status">
		<a
			href="${pageContext.request.contextPath}/mansion/questionpage/${groupindex}/${status.index}"
			class="list-group-item${questionindex == status.index ? " active" : ""}">
			<c:out value="${q.display}" /> <span class="badge pull-right"
			id="badge-${status.index}">${q.state.correct}</span>
		</a>
	</c:forEach>

	<a href="${pageContext.request.contextPath}/"
		class="list-group-item tingo-green-item"> <span
		class="glyphicon glyphicon-arrow-left"></span> <c:out
			value="Back to Mansion" />
	</a>

</div>

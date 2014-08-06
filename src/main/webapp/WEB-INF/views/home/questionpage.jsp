<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="i" value="${0}" scope="request" />

<div class="panel panel-default">

	<div id="Tingo-Feedback"></div>

	<div class="panel-body">
		<c:url var="targetUrl" value="/results" />
		<form:form method="post" action="${targetUrl}" modelAttribute="results">

			<c:set var="counter_question" value="0" scope="request" />

			<c:forEach var="q" items="${repo.questions}" varStatus="status">

				<%--
						<div class="page-header">
							<h4>
								Question ${status.index} <small> </small>
							</h4>
						</div>
--%>

				<!-- ${correctValues.addQuestion()} -->
				<c:set var="counter_task" value="0" scope="request" />

				<div class="well">
					<%-- 							<h4>${q.title}</h4> --%>
					<jsp:include page="/resources/questions/${repo.groupItem.base}/${q.file}" />
				</div>

				<!-- ${results.addQuestion()} -->
				<c:set var="counter_question" value="${counter_question+1}"
					scope="request" />

			</c:forEach>

			<form:button class="btn btn-primary btn-lg" type="submit">Continue &rarr;</form:button>
			

		</form:form>
	</div>
</div>



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
		<form:form method="post" modelAttribute="results">

			<c:choose>
				<c:when test="${state=='QUIZ'}">

					<c:set var="counter_question" value="0" scope="request" />

					<c:forEach var="q"
						items="${repo.sectionlist[si].groupitemlist[gi].questionitemlist}"
						varStatus="status">

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
							<jsp:include page="/resources/questions/${q.file}" />
						</div>

						<!-- ${results.addQuestion()} -->
						<c:set var="counter_question" value="${counter_question+1}"
							scope="request" />

					</c:forEach>

					<form:button class="btn" type="submit">Submit</form:button>
				</c:when>

				<c:when test="${state=='REVIEW'}">
					<h4>REVIEW</h4>
				</c:when>

				<c:when test="${state=='IMAGE'}">
					<c:choose>
						<c:when test="${not empty imagepanel}">
							<img
								src="${pageContext.request.contextPath}/resources/questions/${imagepanel}"
								class="img-responsive" alt="Responsive image">
						</c:when>
						<c:otherwise>
							<jsp:include page="/resources/questions/emptyQuestion.jsp" />
						</c:otherwise>
					</c:choose>
				</c:when>

				<c:otherwise>
					<h4>Unknown state: [${state}]</h4>
				</c:otherwise>

			</c:choose>
		</form:form>
	</div>
</div>



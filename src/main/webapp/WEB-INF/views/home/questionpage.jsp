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
				<c:when test="${empty file}">
					<c:forEach var="q"
						items="${Repo.sectionlist[si].groupitemlist[gi].questionitemlist}"
						varStatus="status">

						<div class="well">
							<h4>${q.title}</h4>
							<jsp:include page="/resources/questions/${q.file}" />
						</div>

					</c:forEach>

					<form:button class="btn" type="submit">Submit</form:button>
				</c:when>

				<c:otherwise>
					<jsp:include page="${file}" />
				</c:otherwise>
			</c:choose>
		</form:form>
	</div>
</div>



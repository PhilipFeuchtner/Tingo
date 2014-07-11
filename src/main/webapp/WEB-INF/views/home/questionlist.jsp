<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="list-group">
	<c:set var="si" value="${Repo.index}" scope="request" />
	<c:set var="gi" value="${Repo.sectionlist[si].index}" scope="request" />
	<c:set var="qi" value="${Repo.sectionlist[gi].groupitemlist[gi].index}"
		scope="request" />
	<c:set var="ti" value="${Repo.index}" scope="request" />

	<!-- ${si} ${gi} ${qi} -->

	<c:forEach var="q" items="${Repo.sectionlist[si].groupitemlist}"
		varStatus="status">

		<c:set var="base" value="/mansion/questionpage/${status.index}" />
		<c:url var="pageUrl" value="${base}" />

		<c:choose>
			<c:when test="${gi == status.index}">
				<a href="${pageUrl}" class="list-group-item active"><c:out
						value="${q.title}" /> <c:if test="${q.count != 0}">
						<span class="badge pull-right">${q.count}</span>
					</c:if></a>

				<c:url var="quizUrl" value="${base}">
					<c:param name="quiz" value="start" />
				</c:url>

				<a href="${quizUrl}" class="list-group-item list-group-item-info"><span
					class="glyphicon glyphicon-arrow-right"></span> Start Quiz</a>

				<c:if test="${not empty q.media}">
					<c:forEach var="m" items="${q.media}">
						<a
							href="${pageContext.request.contextPath}/resources/questions/${m.link}"
							class="list-group-item list-group-item-info"><span
							class="glyphicon glyphicon-paperclip"></span> <c:out value="${m.label}" /></a>
					</c:forEach>
				</c:if>

				<c:set var="imagepanel" value="${q.image}" scope="request" />

			</c:when>
			<c:otherwise>
				<a href="${pageUrl}" class="list-group-item"><c:out
						value="${q.title}" /></a>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<a href="${pageContext.request.contextPath}/"
		class="list-group-item tingo-green-item"> <span
		class="glyphicon glyphicon-arrow-left"></span> Back to Mansion
	</a>

</div>

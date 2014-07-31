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
	<div class="panel-body">
		<c:choose>
			<c:when test="${not empty imagepanel}">
				<img
					src="${pageContext.request.contextPath}/resources/questions/${repo.groupItem.base}/${imagepanel}"
					class="img-responsive" alt="Responsive image">
			</c:when>
			<c:otherwise>
				<jsp:include page="/resources/questions/emptyQuestion.jsp" />
			</c:otherwise>
		</c:choose>
	</div>
</div>



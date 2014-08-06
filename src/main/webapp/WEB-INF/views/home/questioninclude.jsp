<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<head>
<c:url var="baseUrl"
	value="/resources/questions/${repo.groupItem.base}/" />
<%-- <base href="${pageContext.request.contextPath}/resources/questions/${repo.groupItem.base}/" /> --%>
<base href="${baseUrl}" />
</head>

<body>
	<c:url var="back" value="/mansion/questionpage/${return_index}" />

	<div class="well">
		<a href="${back}">
			<button class="btn btn-primary btn-lg" type="button">Back
				&larr;</button>
		</a>
	</div>


	<c:set var="file" value="${repo.groupItem.media[media_index].link}" />

	<div class="panel panel-default">

		<div class="panel-heading">
			<h3 class="panel-title">${repo.groupItem.media[media_index].label}
				${file}</h3>
		</div>

		<div class="panel-body">
			<%@ include
				file="/resources/questions/Capitalisation/capitalisation.jsp"%>
			<%-- 					<jsp:include page="/resources/questions/${repo.groupItem.base}/${q.file}" /> --%>

		</div>

	</div>

	<div class="well">
		<a href="${back}">
			<button class="btn btn-primary btn-lg" type="button">Back
				&larr;</button>
		</a>
	</div>

</body>
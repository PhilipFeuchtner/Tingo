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
			<jsp:include page="${file}" />

			<c:if test="${questionindex != null}">
				<form:button class="btn" type="submit">Submit</form:button>
			</c:if>

		</form:form>
	</div>
</div>



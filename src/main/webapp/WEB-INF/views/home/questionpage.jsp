<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib prefix="tingo" uri="/WEB-INF/tags/tingotags.tld"%>


<div class="panel panel-default">
	
	<div id="Tingo-Feedback"></div>

	<div class="panel-body">
		<jsp:include page="${file}" />
	</div>

	<c:if test="${questionindex != null}">
		<tingo:submit />
	</c:if>
</div>



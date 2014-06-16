<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<h2>QuestionRendererTemplate</h2>
<p>
	Hello
	<security:authentication property="principal.username" />
	!
</p>

<div class="modal-body row">
	<div class="col-md-4">
		<tiles:insertAttribute name="questionlist" defaultValue="" />
	</div>
	<div class="col-md-8">
		<tiles:insertAttribute name="questionpage" defaultValue="" />
	</div>
</div>

<script src="<c:url value="/resources/js/qp-loader.js" />"></script>


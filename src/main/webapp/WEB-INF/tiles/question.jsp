<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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

		<c:if test="${not empty feedback}">
			<c:set value="feedback-${fn:toLowerCase(feedback.type)}"
				var="alertClass" />

			<div class="alert ${alertClass}">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<%
					/* Display a message by its code. If the code was not found, it will be displayed as default text */
				%>
				<s:message text="${feedback.message}" />
			</div>
		</c:if>

		<tiles:insertAttribute name="questionpage" defaultValue="" />
	</div>
</div>

<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	// console.log(contextPath);
</script>
<script src="<c:url value="/resources/js/qp-loader.js" />"></script>


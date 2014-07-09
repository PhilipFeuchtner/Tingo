<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<!-- <h2>QuestionRendererTemplate</h2> -->

<div class="row">

	<div class="col-sm-3">
		<tiles:insertAttribute name="questionlist" defaultValue="" />
	</div>

	<div class="col-sm-9">
		<tiles:insertAttribute name="questionpage" defaultValue="" />
	</div>

</div>

<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}", groupindex = "${groupindex}", questionindex = "${questionindex}";

	// console.log(contextPath);
</script>
<script src="<c:url value="/resources/js/qp-loader.js" />"></script>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<%@ taglib prefix="tingo" uri="/WEB-INF/tingotags.tld"%>


<div class="panel panel-default">
	<div class="panel-body">
		<jsp:include page="${file}" />
	</div>

	<c:if test="${questionindex != null}">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a id="qp_link" href="#"> <span
					id="qp_badge" class="badge pull-right">qp_badge</span>
					<button id="qp_submit" type="button" class="btn btn-default">Submit</button>
					<span id="qp_text">qp_text</span>
			</a></li>
		</ul>
	</c:if>
</div>



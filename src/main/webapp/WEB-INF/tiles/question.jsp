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
		<div class="sidebar-nav">
			<div class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<span class="visible-xs navbar-brand">Sidebar menu</span>
				</div>
				<div class="navbar-collapse collapse sidebar-navbar-collapse">
					<ul class="nav navbar-nav">

						<c:set var="si" value="${Repo.index}" scope="request"/>
						<c:set var="gi" value="${Repo.sectionlist[si].index}" scope="request" />
						<c:set var="qi"
							value="${Repo.sectionlist[gi].groupitemlist[gi].index}" scope="request"/>
						<c:set var="ti" value="${Repo.index}" scope="request"/>


						<c:forEach var="q"
							items="${Repo.sectionlist[si].groupitemlist}"
							varStatus="status">
							<li><c:set var="href"
									value="${pageContext.request.contextPath}/mansion/questionpage/${gi}/${status.index}" />
								<c:choose>
									<c:when test="${qi == status.index}">
										<a href="${href}"><c:out value="${q.title}" /></a>
									</c:when>
									<c:otherwise>
										<a href="${href}" class="active"><c:out value="${q.title}" /></a>
									</c:otherwise>
								</c:choose></li>
						</c:forEach>

						<li><a href="${pageContext.request.contextPath}/"
							class="list-group-item tingo-green-item"> <span
								class="glyphicon glyphicon-arrow-left"></span>Back to Mansion
						</a></li>

					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
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


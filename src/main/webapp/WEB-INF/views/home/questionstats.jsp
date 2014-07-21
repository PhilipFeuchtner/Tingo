<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">

	<div id="Tingo-Feedback"></div>

	<div class="panel-body">
		<c:set var="g_state" value="${repo.groupItem.state}" />

		<h3>
			Results <small>${g_state.score}/ ${g_state.solved}</small>
		</h3>

		<ul class="list-group">
			<c:forEach var="q" items="${repo.questions}" varStatus="status">
				<c:set var="state" value="${q.state}" />

				<c:choose>
					<c:when test="${state.solved == 'CORRECT'}">
						<c:set var="q_class"
							value="list-group-item list-group-item-success" />
					</c:when>
					<c:when test="${state.solved == 'PARTLY'}">
						<c:set var="q_class"
							value="list-group-item list-group-item-warning" />
					</c:when>

					<c:when test="${state.solved == 'INCORRECT'}">
						<c:set var="q_class"
							value="list-group-item list-group-item-danger" />
					</c:when>

					<c:otherwise>
						<c:set var="q_class" value="list-group-item list-group-item-info" />
					</c:otherwise>

				</c:choose>

				<li class="${q_class}">

					<div class="page-header">
						<h4>
							Question ${status.index +1}
							<c:if test="${not empty q.title}">
								<small> ${q.title}</small>
							</c:if>
							<span class="badge pull-right">${state.score}</span>
						</h4>
					</div> ${state.solved}

				</li>
			</c:forEach>
		</ul>
	</div>
</div>



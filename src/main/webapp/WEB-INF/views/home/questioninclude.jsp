<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url var="back" value="/mansion/questionpage/${return_index}" />

<div class="well">
	<a href="${back}"><span class="label label-default">Back</span></a>
</div>

<div class="panel panel-default">

	<div class="panel-heading">
		<h3 class="panel-title">${repo.groupItem.media[media_index].label}</h3>
	</div>

	<div class="panel-body">

		<c:set var="base"
			value="/resources/questions/${repo.groupItem.media[media_index].link}" />

		<c:import url="${base}" />
	</div>

</div>

<div class="well">
	<a href="${back}"><span class="label label-default">Back</span></a>
</div>


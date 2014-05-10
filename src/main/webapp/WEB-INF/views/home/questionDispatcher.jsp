<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<h2>QuestionDispatcher</h2>
<p>
	Hello <security:authentication property="principal.username" />! Welcome to the Spring MVC Quickstart application! 	
</p>

<div id="Content svg"></div>

<script src="<c:url value="/resources/js/qd-loader.js" />"></script>
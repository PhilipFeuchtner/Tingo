<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="questionid" required="true"%>
<%@ attribute name="correct" required="false" type="java.lang.Boolean"%>
<%@ attribute name="style" required="false"%>
<%@ attribute name="score" required="false" type="java.lang.Integer"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Integer scoreValue = score == null ? 1 : score;
	boolean correctValue = correct != null && correct;
%>

[${counter_question}/${counter_task}]

<form:checkbox class="form-control"
	path="resultList[${counter_question}]" value="${counter_task}" />

<c:set var="sc" value="<%=scoreValue%>" />

<c:set var="cv" value="-1" />
<c:if test="<%=correctValue%>">
	<c:set var="cv" value="${counter_task}" />
</c:if>

<!-- ${correctValues.addTask(cv,sc,2)} -->

<c:set var="counter_task" value="${counter_task+1}" scope="request" />


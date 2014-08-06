<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="questionid" required="true"%>
<%@ attribute name="correct" required="false" type="java.lang.Boolean"%>
<%@ attribute name="label" required="true"%>
<%@ attribute name="style" required="false"%>
<%@ attribute name="score" required="false" type="java.lang.Integer"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Integer scoreValue = score == null ? 1 : score;
	boolean correctValue = correct != null && correct;
%>

<div class="row">
	<div class="col-sm-1">
		<form:checkbox id="check-${counter_question}-${counter_task}"
			 path="resultList[${counter_question}]"
			value="${counter_task}" />
	</div>
	<div class="col-sm-11">
		<label for="check-${counter_question}-${counter_task}"><%=label%></label>
	</div>
</div>

<c:set var="sc" value="<%=scoreValue%>" />

<c:set var="cv" value="" />
<c:if test="<%=correctValue%>">
	<c:set var="cv" value="${counter_task}" />
</c:if>

<!-- ${correctValues.addTask(cv,sc,2)} -->

<c:set var="counter_task" value="${counter_task+1}" scope="request" />
<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="questionid" required="true"%>
<%@ attribute name="correct" required="false"%>
<%@ attribute name="label" required="true"%>
<%@ attribute name="style" required="false"%>
<%@ attribute name="score" required="false" type="java.lang.Integer"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Integer scoreValue = score == null ? 1 : score;
%>

<form:radiobutton id="check-${counter_question}-${counter_task}"
	class="form-control" path="resultList[${counter_question}][0]"
	value="${counter_task}" />
<label for="check-${counter_question}-${counter_task}"><%=label%></label>

<c:set var="sc" value="<%=scoreValue%>" />
<!-- ${counter_task == 0 ? correctValues.addTask(correct,sc,1) : ""} -->
<!-- ${counter_task == 0 ? resultlist.add("") : ""} -->

<c:set var="counter_task" value="${counter_task+1}" scope="request" />


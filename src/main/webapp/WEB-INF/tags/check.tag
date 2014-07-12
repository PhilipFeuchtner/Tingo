<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="questionid" required="true"%>
<%@ attribute name="correct" required="false"%>
<%@ attribute name="style" required="false"%>
<%@ attribute name="score" required="false" type="java.lang.Integer" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	Integer	scoreValue = score == null ? 1 : score;
%>

[${counter_question}/${counter_task}]

<form:checkbox class="form-control" path="resultList[${counter_question}]" value="${counter_task}" />

<c:set var="sc" value="<%= scoreValue %>" />
<!-- ${CorrectValues.addTask(correct,sc,2)} -->

<c:set var="counter_task" value="${counter_task+1}" scope="request" /> 


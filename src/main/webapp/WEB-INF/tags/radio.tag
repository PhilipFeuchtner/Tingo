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

<form:radiobutton class="form-control" path="resultList[${counter_question}][0]" value="${counter_task}" />

<c:set var="sc" value="<%= scoreValue %>" />
<!-- ${counter_task == 0 ? CorrectValues.addTask(correct,sc,1) : ""} -->
<!-- ${counter_task == 0 ? resultlist.add("") : ""} -->

<c:set var="counter_task" value="${counter_task+1}" scope="request" /> 


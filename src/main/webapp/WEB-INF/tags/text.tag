<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="questionid" required="true"%>
<%@ attribute name="response" required="false"%>
<%@ attribute name="size" required="false"%>
<%@ attribute name="correct" required="true"%>
<%@ attribute name="placeholder" required="false"%>
<%@ attribute name="score" required="false" type="java.lang.Integer"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String placeh = placeholder == null ? "" : placeholder;
	Integer scoreValue = score == null ? 1 : score;
	String sizeClass = "form-control";
	if (size != null) {
		sizeClass = "tingo-" + size;
	}
%>

<c:set var="sc" value="<%=sizeClass%>" />

<form:input path="resultList[${counter_question}][${counter_task}]"
	type="text" class="${sc} tingo-input" placeholder="<%= placeh %>" />

<c:set var="sv" value="<%=scoreValue%>" />
<!-- ${correctValues.addTask(correct,sv,0)} -->

<c:set var="i" value="${1+i}" scope="request" />
<c:set var="counter_task" value="${counter_task+1}" scope="request" />


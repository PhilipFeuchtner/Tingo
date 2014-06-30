<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="questionid" required="false"%>
<%@ attribute name="response" required="false"%>
<%@ attribute name="correct" required="false"%>
<%@ attribute name="placeholder" required="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String placeh = placeholder == null ? "Here!" : placeholder;
%>

<form:input path="taskList[${i}].value" type="text"
	class="form-control" placeholder="<%= placeh %>"></form:input>

<c:set var="i" value="${1+i}" scope="request" />




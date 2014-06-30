<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="questionid" required="false"%>
<%@ attribute name="response" required="false"%>
<%@ attribute name="correct" required="false"%>
<%@ attribute name="placeholder" required="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<% String placeh = placeholder == null ? "Here!" : placeholder; %>

 <form:input path="questionindex" type="text" class="form-control-x tingo-form-control" placeholder="<%= placeh %>"></form:input>


<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="questionid" required="true"%>
<%@ attribute name="response" required="true"%>
<%@ attribute name="correct" required="false"%>
<%@ attribute name="style" required="false"%>

<div class="panel panel-default tingo-question" qid="<%=questionid%>"
	response="<%=response%>">

	<div class="panel-heading">
		<h4 class="panel-title">Tingo Check Choice</h4>

	</div>
	<div class="panel-body">
		<a href="" <%=style == null ? "" : "class=\"" + style + "\""%>>

			<jsp:doBody />

		</a>
	</div>

	<div class="panel-footer">
		<span class="glyphicon glyphicon-minus"></span>
	</div>
</div>

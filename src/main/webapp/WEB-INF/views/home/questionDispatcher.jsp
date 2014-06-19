<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<h2>QuestionDispatcher</h2>
<p>
	Hello
	<security:authentication property="principal.username" />
	!
</p>

<p>
	<svg id="svg-mansion"></svg>
</p>

<ul class="nav nav-pills nav-stacked">
  <li class="active">
    <a id="qd_link" href="mansion/ajax">
      <span id="qd_badge" class="badge pull-right">qd_badge</span>
      <button id="qd_submit" type="button" class="btn btn-default">Submit</button>
      <span id="qd_text">qd_text</span>
    </a>
  </li>
</ul>


<script src="<c:url value="/resources/js/snap.svg-min.js" />"></script>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	// console.log(contextPath);
</script>
<script src="<c:url value="/resources/js/qd-loader.js" />"></script>



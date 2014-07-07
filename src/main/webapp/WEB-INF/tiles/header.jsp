<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<div class="navbar navbar-default navbar-inverse navbar-fixed-top"
	role="navigation">

	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#nav-collapse">

				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>

			</button>
			<a class="navbar-brand" href="#">Tingo Project</a>

		</div>
		<!-- 		<div class="nav-collapse collapse" id="nav-collapse"> -->
		<!-- 			<ul class="nav navbar-nav"> -->
		<%-- 				<li class="active"><a href='<s:url value="/">  --%>
		<%-- 					</s:url>'>Home</a></li> --%>

		<!-- 				<li class="active"><a href="#">Link</a></li> -->
		<!-- 				<li><a href="#">Link</a></li> -->


		<!-- 			</ul> -->

		<div class="nav-collapse collapse" id="nav-collapse">
			<ul class="nav navbar-nav">
				<li><a href="#">Test</a></li>
				<li><security:authorize access="!isAuthenticated()">
						<a href='<s:url value="/signin"></s:url>'> <span
							class="label label-default">Sign in </span></a>
					</security:authorize> <security:authorize access="isAuthenticated()">
						<a href='<s:url value="/logout"></s:url>'> <span
							class="label label-default">Logout (<security:authentication
									property="principal.username" />)
						</span>
						</a>
					</security:authorize></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>

</div>
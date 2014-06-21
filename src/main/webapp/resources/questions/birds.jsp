<%@ taglib prefix="tingo" uri="/WEB-INF/tingotags.tld"%>

<h1>Question</h1>
<p>What is my favorite bird?</p>

<div class="panel panel-default">
  <div class="panel-heading">Bird 1</div>
  <div class="panel-body">
  <tingo:multipleChoice>
  <button type="button" class="btn btn-default btn-lg">
   
    <img src="${pageContext.request.contextPath}/resources/img/bird1.png" alt="alt text" title="Bird 1" />
  </button>
  </tingo:multipleChoice>
  </div>
 
</div>
<div class="panel panel-default">
  <div class="panel-heading">Bird 2</div>
  <div class="panel-body">
   <button type="button" class="btn btn-default btn-lg">
  
    <img src="${pageContext.request.contextPath}/resources/img/bird2.png" alt="alt text" title="Bird 2" />
  </button></div>
</div>
<div class="panel panel-default">
  <div class="panel-heading">B1rd 3</div>
  <div class="panel-body">
   <button type="button" class="btn btn-default btn-lg">
   
    <img src="${pageContext.request.contextPath}/resources/img/bird3.png" alt="alt text" title="Bird 3" />
  </button></div>
</div>

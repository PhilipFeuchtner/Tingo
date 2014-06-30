<%@ taglib prefix="tingo" uri="/WEB-INF/tags/tingotags.tld"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tt"%>

<h1>Question</h1>
<p>Fill in the missing words, please.</p>

<ul class="list-group">

	<li class="list-group-item">
		<p>
			<tt:text questionid="q1" placeholder="Ygritte" correct="Ygritte" />
		</p>
		<p>
			You Know
			<tt:text questionid="q2" placeholder="Nothing" correct="Nothing" />
			, Jon Snow.
		</p>
	</li>

	<li class="list-group-item">
		<p>Ned Stark</p>
		<p>
			<tt:text questionid="q3" placeholder="Winter" correct="Winter" />
			is
			<tt:text questionid="q3" placeholder="comming" correct="comming" />
			.
		</p>
	</li>

	<li class="list-group-item">
		<p>
			<tt:text questionid="q4" correct="Berry" />
		</p>
		<p>
			If You Think This Has
			<tt:text questionid="q5" placeholder="A Happy Ending"
				correct=">A Happy Ending" />
			, You Haven't Been
			<tt:text questionid="q6" placeholder="Paying Attention"
				correct="Paying Attention" />
			.
		</p>
	</li>

</ul>
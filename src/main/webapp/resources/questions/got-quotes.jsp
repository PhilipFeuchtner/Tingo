<%@ taglib tagdir="/WEB-INF/tags" prefix="tingo"%>

<h1>Question</h1>
<p>Fill in the missing words, please.</p>

<ul class="list-group">

	<li class="list-group-item">
		<p>
			<tingo:text questionid="q1" placeholder="Ygritte" correct="Ygritte" />
		</p>
		<p>
			You Know
			<tingo:text questionid="q2" placeholder="Nothing" correct="Nothing" />
			, Jon Snow.
		</p>
	</li>

	<li class="list-group-item">
		<p>Ned Stark</p>
		<p>
			<tingo:text questionid="q3" placeholder="Winter" correct="Winter" />
			is
			<tingo:text questionid="q3" placeholder="comming" correct="comming" />
			.
		</p>
	</li>

	<li class="list-group-item">
		<p>
			<tingo:text questionid="q4" correct="Ramsay Snow" placeholder="Ramsay Snow"/>
		</p>
		<p>
			If You Think This Has
			<tingo:text questionid="q5" placeholder="A Happy Ending"
				correct=">A Happy Ending" />
			, You Haven't Been
			<tingo:text questionid="q6" placeholder="Paying Attention"
				correct="Paying Attention" />
			.
		</p>
	</li>

</ul>
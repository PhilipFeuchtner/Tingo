<%@ taglib tagdir="/WEB-INF/tags" prefix="tingo"%>

<h1>Question</h1>
<p>Fill in the missing words, please.</p>

<ul class="list-group">

	<li class="list-group-item">
		<p>
			<tingo:text questionid="q1" correct="Ygritte" />
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
			<tingo:text questionid="q4" correct="Ramsay Snow"
				placeholder="Ramsay Snow" />
		</p>
		<p>
			If You Think This Has
			<tingo:text questionid="q5" placeholder="A Happy Ending"
				correct="A Happy Ending" />
			, You Haven't Been
			<tingo:text questionid="q6" placeholder="Paying Attention"
				correct="Paying Attention" />
			.
		</p>
	</li>

	<li class="list-group-item">
		<p>
			""Oh, my sweet summer child," Old Nan said quietly, "what do you know
			of
			<tingo:text questionid="q7" placeholder="fear" correct="fear" />
			?
		</p>
		<p>
			<tingo:text questionid="q8" placeholder="Fear" correct="Fear" />
			is for the winter, my little lord, when the snows fall a hundred feet
			deep and the ice wind comes howling out of the north.
			<tingo:text questionid="q9" placeholder="Fear" correct="Fear" />
			is for the long night, when the sun hides its face for years at a
			time, and little children are born and live and die all in darkness
			while the direwolves grow gaunt and hungry, and the white walkers
			move through the woods"
		</p>
	</li>
</ul>
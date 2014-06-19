package de.uniko.iwm.tingo.simple;

public class SimpleState {

	public enum STATE {UNSEEN, PROCESSING, CLOSED};
	public enum SOLVED {INCORRECT, PARTLY, CORRECT}
	
	private SOLVED correct;
	private int score;
	private STATE state;
	
	public SimpleState() {
		correct = SOLVED.INCORRECT;
		score = 0;
		state = STATE.UNSEEN;
	}

	public SOLVED getCorrect() {
		return correct;
	}

	public void setCorrect(SOLVED correct) {
		this.correct = correct;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public STATE getState() {
		return state;
	}

	public void setState(STATE state) {
		this.state = state;
	}
}

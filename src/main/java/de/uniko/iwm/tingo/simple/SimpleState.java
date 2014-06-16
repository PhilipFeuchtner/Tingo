package de.uniko.iwm.tingo.simple;

public class SimpleState {

	public enum STATE {UNSEEN, PARTLY, CLOSED};
	
	private boolean correct;
	private int score;
	private STATE state;
	
	public SimpleState() {
		correct = false;
		score = 0;
		state = STATE.UNSEEN;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
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

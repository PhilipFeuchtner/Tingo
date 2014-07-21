package de.uniko.iwm.Repo;

public class SimpleState {

	public enum SOLVED {
		INCORRECT, PARTLY, CORRECT
	}

	private SOLVED solved;
	private int score;
	private int count;

	public SimpleState() {
		solved = SOLVED.INCORRECT;
		score = 0;
		count = 0;
	}

	public SOLVED getSolved() {
		return solved;
	}

	public void setSolved(SOLVED solved) {
		this.solved = solved;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	// -------------------------------------------------------------

	public boolean isValid() {
		switch (solved) {
		case CORRECT:
			return true;
		default:
			return false;
		}
	}
	
	public void increment() {
		count++;
	}
	
	@Override
	public String toString() {
		return "State [" + solved + ", " + score + ", " + count + "]";
	}
}

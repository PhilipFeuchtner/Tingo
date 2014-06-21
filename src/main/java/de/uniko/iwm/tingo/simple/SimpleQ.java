package de.uniko.iwm.tingo.simple;

import java.util.HashSet;
import java.util.Set;

import de.uniko.iwm.tingo.simple.SimpleState.SOLVED;

public class SimpleQ {

	private String display;
	private String file;

	private Set<String> correctResp;

	private SimpleState state;

	public SimpleQ(String display, String file, Set<String> correctRest) {
		this.display = display;
		this.file = file;
		this.correctResp = correctRest;

		state = new SimpleState();
	}

	// --------------------------------------------------------

	public SOLVED validate(Set<String> challenge) {

		if (challenge.containsAll(correctResp)) {
			return correctResp.containsAll(challenge) ? SOLVED.CORRECT
					: SOLVED.PARTLY;
		} 
		
		for (String test : challenge) {
			if (correctResp.contains(test)) return SOLVED.PARTLY;
		}

		return SOLVED.INCORRECT;
	}

	// --------------------------------------------------------

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public Set<String> getCorrectResp() {
		return correctResp;
	}

	public void setCorrectResp(Set<String> correctResp) {
		this.correctResp = correctResp;
	}

	public SimpleState getState() {
		return state;
	}

	public void setState(SimpleState state) {
		this.state = state;
	}
}

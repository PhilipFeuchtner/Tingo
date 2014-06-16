package de.uniko.iwm.tingo.simple;

import de.uniko.iwm.tingo.simple.SimpleState.STATE;

public class SimpleQ {

	private String display;
	private String file;
	
	private String correctResp;
	
	private SimpleState state;
	
	public SimpleQ(String display, String file, String correctRest) {
		this.display = display;
		this.file = file;
		this.correctResp = correctRest;
		
		state = new SimpleState();
	}

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

	public String getCorrectResp() {
		return correctResp;
	}

	public void setCorrectResp(String correctResp) {
		this.correctResp = correctResp;
	}

	public SimpleState getState() {
		return state;
	}

	public void setState(SimpleState state) {
		this.state = state;
	}	
}

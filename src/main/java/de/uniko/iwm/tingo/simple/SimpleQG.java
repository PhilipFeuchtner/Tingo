package de.uniko.iwm.tingo.simple;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class SimpleQG {
	
	private String display;
	private String svgid;
	
	@JsonIgnore
	private List <SimpleQ> questions;
	
	private SimpleState state;
	
	public SimpleQG(String display, String svgid, List <SimpleQ> questions) {
		this.display = display;
		this.svgid = svgid;
		this.questions = questions;
		
		state = new SimpleState();
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getSvgid() {
		return svgid;
	}

	public void setSvgid(String svgid) {
		this.svgid = svgid;
	}

	public List<SimpleQ> getQuestions() {
		return questions;
	}

	public void setQuestions(List<SimpleQ> questions) {
		this.questions = questions;
	}

	public SimpleState getState() {
		return state;
	}

	public void setState(SimpleState state) {
		this.state = state;
	}	
}

package de.uniko.iwm.tingo.task;

public class Correct {

	private String value;

	public Correct() {

	}

	public Correct(String value) {
		this.value = value;
		
		System.out.println(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

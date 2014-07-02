package de.uniko.iwm.tingo.task;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class CorrectValueWrapper {

	private HashMap<Integer, String> correctValue;
	
	public CorrectValueWrapper() {
		correctValue = new HashMap<Integer, String>();
	}

	public HashMap<Integer, String> getCorrectValues() {
		return correctValue;
	}
	
	public void add(Integer i, String value) {
		correctValue.put(i, value);
	}
}

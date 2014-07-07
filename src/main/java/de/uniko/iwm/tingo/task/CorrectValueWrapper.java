package de.uniko.iwm.tingo.task;

import java.util.HashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Scope("session")
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

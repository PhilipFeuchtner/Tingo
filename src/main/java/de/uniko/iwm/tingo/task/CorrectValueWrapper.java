package de.uniko.iwm.tingo.task;

import java.io.Serializable;
import java.util.HashMap;

import de.uniko.iwm.Repo.TaskItem;

public class CorrectValueWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2420474683858920696L;
	private HashMap<Integer, TaskItem> values;
	
	public CorrectValueWrapper() {
		values = new HashMap<Integer, TaskItem>();
	}

	public HashMap<Integer, TaskItem> getValues() {
		return values;
	}
	
	public void add(Integer i, String correct, int score) {
		values.put(i, new TaskItem(correct, score));
	}
}

package de.uniko.iwm.tingo.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.uniko.iwm.Repo.TaskItem;

public class CorrectValueWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2420474683858920696L;
	private List<List<TaskItem>> values;

	public CorrectValueWrapper() {
		values = new ArrayList<List<TaskItem>>();
	}

	public List<List<TaskItem>> getValues() {
		return values;
	}

	public void addQuestion() {
		List<TaskItem> tasks = new ArrayList<TaskItem>();
		
		values.add(tasks);
	}

	public void addTask(String correct, int score, int type) {
		List<TaskItem> tasks = values.get(values.size() -1);
		
		tasks.add(new TaskItem(correct, score, type));
	}

}

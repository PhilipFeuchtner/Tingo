package de.uniko.iwm.tingo.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.uniko.iwm.Repo.TaskItem;

public class CorrectValueWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2420474683858920696L;
	private static final Logger LOG = LoggerFactory.getLogger(CorrectValueWrapper.class); 
			
	private List<List<TaskItem>> values;

	private int count_questions, count_tasks;

	public CorrectValueWrapper() {
		values = new ArrayList<List<TaskItem>>();
		count_questions = 0;
		count_tasks = 0;
	}

	public CorrectValueWrapper(List<List<TaskItem>> values) {
		this.values = values;
		count_questions = 0;
		count_tasks = 0;
	}

	public List<List<TaskItem>> getValues() {
		return values;
	}

	public void addQuestion() {
		count_questions++;
		count_tasks = 0;

		if (count_questions > values.size()) {
			List<TaskItem> tasks = new ArrayList<TaskItem>();
			values.add(tasks);
		}
	}

	public void addTask(String correct, int score, int type) {
		TaskItem ti = new TaskItem(correct, score, type);
		
		addTask(ti);
	}
		
	public void addTask(TaskItem ti) {
		count_tasks++;

		List<TaskItem> tasks = values.get(count_questions - 1);

		if (count_tasks > tasks.size()) {
			tasks.add(ti);
		} else {
			tasks.set(count_tasks - 1, ti);
		}
	}
}

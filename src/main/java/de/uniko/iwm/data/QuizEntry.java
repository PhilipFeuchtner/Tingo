package de.uniko.iwm.data;

import java.util.ArrayList;
import java.util.List;

import de.uniko.iwm.Repo.TaskItem;

public class QuizEntry {
	List<List<TaskItem>> data;

	public QuizEntry() {
		data = new ArrayList<List<TaskItem>>();
	}

	public List<List<TaskItem>> getData() {
		return data;
	}

	public void setData(List<List<TaskItem>> data) {
		this.data = data;
	}
}

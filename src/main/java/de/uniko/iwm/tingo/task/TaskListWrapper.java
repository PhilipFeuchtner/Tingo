package de.uniko.iwm.tingo.task;

import java.util.List;

public class TaskListWrapper {

	private List<Task> taskList;

	public TaskListWrapper() {

	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public void add(Task task) {
		taskList.add(task);
	}
}

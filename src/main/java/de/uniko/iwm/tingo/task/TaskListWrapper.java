package de.uniko.iwm.tingo.task;

import java.util.ArrayList;
import java.util.List;

public class TaskListWrapper {

	private List<Task> taskList;

	public TaskListWrapper() {
        this.taskList = new ArrayList<Task>();
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public int add(Task task) {
		taskList.add(task);
		
		return taskList.size() -1; 
	}
}

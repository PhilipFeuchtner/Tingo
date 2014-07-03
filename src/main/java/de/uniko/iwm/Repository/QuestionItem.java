package de.uniko.iwm.Repository;

import java.util.List;

public class QuestionItem {

	private List<TaskItem> taskitemlist;
	
	public QuestionItem() {
		
	}

	public List<TaskItem> getTaskitemlist() {
		return taskitemlist;
	}

	public void setTaskitemlist(List<TaskItem> taskitemlist) {
		this.taskitemlist = taskitemlist;
	}
}

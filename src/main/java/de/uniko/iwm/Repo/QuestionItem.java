package de.uniko.iwm.Repo;

import java.util.ArrayList;
import java.util.List;

public class QuestionItem {

	private String file;
	private String title;
	
	private List<TaskItem> taskitemlist;
	
	public QuestionItem() {
		 taskitemlist = new ArrayList<TaskItem>();
	}

	public List<TaskItem> getTaskitemlist() {
		return taskitemlist;
	}

	public void setTaskitemlist(List<TaskItem> taskitemlist) {
		this.taskitemlist = taskitemlist;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

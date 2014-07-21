package de.uniko.iwm.Repo;

import java.util.ArrayList;
import java.util.List;

public class QuestionItem {

	private String file;
	private String title;
	private SimpleState state;
	
	private List<TaskItem> taskitemlist;
	
	public QuestionItem() {
		 taskitemlist = new ArrayList<TaskItem>();
		 state = new SimpleState();
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

	public SimpleState getState() {
		return state;
	}

	public void setState(SimpleState state) {
		this.state = state;
	}
}

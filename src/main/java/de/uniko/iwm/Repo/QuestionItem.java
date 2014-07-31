package de.uniko.iwm.Repo;

import java.util.ArrayList;
import java.util.List;

public class QuestionItem {

	private String file;
	private String title;
	private SimpleState state = new SimpleState();;
	private String index;
	
	private List<TaskItem> taskitemlist = new ArrayList<TaskItem>();
	
	public QuestionItem() {
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
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
}

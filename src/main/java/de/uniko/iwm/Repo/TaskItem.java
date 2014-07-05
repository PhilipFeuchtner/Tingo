package de.uniko.iwm.Repo;

public class TaskItem {

	private String value;
	
	public TaskItem() {
		System.out.println("Task created.");
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		System.out.println(" -> Task set: " + value);
		this.value = value;
	}
}

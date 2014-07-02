package de.uniko.iwm.tingo.task;

public class Task {

	private String userInput;

	public Task() {
	}
	
	public String getUserInput() {
		return userInput;
	}

	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}

	@Override
	public String toString() {
		return "Task[" + userInput + "]";
	}
}

package de.uniko.iwm.Repo;

public class TaskItem {

	private String correct, userinput;
	private int score;
	
	public TaskItem() {
		System.out.println("Task created.");
	}

	public TaskItem(String correct, int score) {
		this.correct = correct;
		this.score = score;
		
		System.out.println(this.toString());
	}
	
	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		System.out.println(" -> Task set: " + correct);
		this.correct = correct;
	}

	public String getUserinput() {
		return userinput;
	}

	public void setUserinput(String userinput) {
		this.userinput = userinput;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "TaskItem [" + userinput + ", " + correct + ", " + score + "]"; 
	}
}

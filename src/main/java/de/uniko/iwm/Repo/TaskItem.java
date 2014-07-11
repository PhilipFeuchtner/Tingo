package de.uniko.iwm.Repo;

public class TaskItem {
	
	public enum TYPE {TEXT, RADIO, CHECK};

	private String correct, userinput;
	private int score;
	private TYPE type;
	
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
	
	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TaskItem [" + userinput + ", " + correct + ", " + score + "]"; 
	}
}

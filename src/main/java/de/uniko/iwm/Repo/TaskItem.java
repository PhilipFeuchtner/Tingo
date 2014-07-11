package de.uniko.iwm.Repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.uniko.iwm.home.HomeController;

public class TaskItem {


	private static final Logger LOG = LoggerFactory
			.getLogger(TaskItem.class);

	public enum TYPE {
		TEXT, RADIO, CHECK
	};

	private String correct, userinput;
	private int score;
	private TYPE type;

	public TaskItem() {
		// System.out.println("Task created.");
	}

	public TaskItem(String correct, int score, int type) {
		this.correct = correct;
		this.score = score;

		switch (type) {
		case 0:
			this.type = TYPE.TEXT;
			break;
		case 1:
			this.type = TYPE.RADIO;
			break;
		case 2:
			this.type = TYPE.CHECK;
			break;
		default:
			LOG.error("unknown type: " + type);
		}

		LOG.info(this.toString());
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
		return "TaskItem [" + userinput + ", " + correct + ", " + score + ", "
				+ type + "]";
	}
}

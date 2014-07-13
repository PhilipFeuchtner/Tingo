package de.uniko.iwm.Repo;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.uniko.iwm.home.HomeController;

public class TaskItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5758040001315937898L;
	private static final Logger LOG = LoggerFactory.getLogger(TaskItem.class);

	public enum TYPE {
		TEXT, RADIO, CHECK
	};

	private String correct, userinput = "";
	private int score;
	private TYPE type;
	private boolean valid;

	public TaskItem() {
		// System.out.println("Task created.");
	}

	public TaskItem(String correct, int score, TYPE type) {
		this.correct = correct;
		this.score = score;
		this.type = type;
		valid = false;
	}

	public TaskItem(String correct, int score, int type) {
		this.correct = correct;
		this.score = score;
		valid = false;

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
	
	// -------------------------------------------------------
	
	public  boolean validate() {
		boolean result = false;
		
		switch(type) {
		case TEXT:
		case RADIO:
			result = userinput.equals(correct);
			break;
		case CHECK:
			result = !userinput.isEmpty() && !correct.isEmpty();
			break;
		}
		
		setValid(result);
		
		return result;
	}
	// -------------------------------------------------------

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

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "TaskItem [" + userinput + ", " + correct + ", " + score + ", "
				+ type + ", " + valid + "]";
	}
}

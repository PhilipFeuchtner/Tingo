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
		TEXT, RADIO, CHECK, LETTER
	};

	private String correct = "", userinput = "";
	private int score;
	private TYPE type;
	private boolean valid;

	// private String index;

	public TaskItem() {
		// System.out.println("Task created.");
	}

	public TaskItem(String correct, int score, TYPE type) {
		this.correct = correct;
		this.score = score;
		this.type = type;
		valid = validate();
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
		case 3:
			this.type = TYPE.LETTER;
			break;
		default:
			LOG.error("unknown type: " + type);
		}

		LOG.info(this.toString());
	}

	// -------------------------------------------------------

	public boolean validate() {
		boolean result = false;

		switch (type) {
		case TEXT:
		case RADIO:
		case CHECK:
		case LETTER:
			result = userinput.equals(correct);
			break;
		// case CHECK:
		// result = (!userinput.isEmpty() && !correct.isEmpty())
		// || (userinput.isEmpty() && correct.isEmpty());
		// break;
		default:
			LOG.error("unknown type: " + type);
			result = false;
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

	// public String getIndex() {
	// return index;
	// }
	//
	// public void setIndex(String index) {
	// this.index = index;
	// }

	@Override
	public String toString() {
		return "TaskItem [" +
		/* index + ", " + */userinput + ", " + correct + ", " + score + ", "
				+ type + ", " + valid + "]";
	}
}

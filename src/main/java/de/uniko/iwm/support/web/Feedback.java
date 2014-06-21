package de.uniko.iwm.support.web;

import de.uniko.iwm.tingo.simple.SimpleState.SOLVED;

/**
 * A message to be displayed in web context. Depending on the type, different
 * style will be applied.
 */
public class Feedback {
	/**
	 * Name of the flash attribute.
	 */
	public static final String MESSAGE_ATTRIBUTE = "feedback";

	private final String message;
	private final SOLVED type;

	public Feedback(String message, SOLVED type) {
		this.message = message;
		this.type = type;
	}

	public Feedback(SOLVED type) {
		this.type = type;

		switch (type) {
		case CORRECT:
			message = "Congratulation, the answer is correct.";
			break;
		case PARTLY:
			message = "Well done, the answer is partly correct.";
			break;
		case INCORRECT:
			message = "Sorry, the answer isn't correct.";
			break;
		default:
			message = "- missing value -";
		}
	}

	public String getMessage() {
		return message;
	}

	public SOLVED getType() {
		return type;
	}
}

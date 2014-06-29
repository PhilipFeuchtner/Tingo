package de.uniko.iwm.tingo.question;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TingoTextRenderer extends TagSupport {

	private String questionid;
	private String response;
	private String style;
	private String correct;
	private String placeholder;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4313973045806264100L;
	StringWriter sw = new StringWriter();

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			// out.println("<h2>TextRenderer</h2>");
			
			// out.println("  <div class=\"form-group\">");
			// out.println("  <div class=\"col-md-3\">");
			out.println("    <input path=\"fooList[${i.index}].name\" type=\"text\"");
			out.println("           class=\"form-control-x tingo-form-control\"");
			out.print(placeholder == null ? "" : " placeholder=\"" + placeholder + "\"");
			out.println("     />");
			// out.println(" </div></div>");
			out.println("");
		} catch (IOException e) {
			throw new JspException(e.toString());
		}
		
		return EVAL_PAGE;
	}
	
	public int doAfterTag() {
		return EVAL_BODY_AGAIN;
	}

	public String getQuestionid() {
		return questionid;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

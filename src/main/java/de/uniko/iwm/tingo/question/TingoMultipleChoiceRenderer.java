package de.uniko.iwm.tingo.question;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TingoMultipleChoiceRenderer extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4313973045806264100L;

	private String questionid;
	private String response;
	private String style;

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.print("<div class=\"panel panel-default tingo-question\"");
			out.print("     qid=\"" + questionid + "\"");
			out.print("     response=\"" + response + "\">");
			out.print("  <div class=\"panel-heading\">");
			out.print("    <h4 class=\"panel-title\">Tingo Multiple Choice</h3>");
			out.print("  </div>");
			out.print("  <div class=\"panel-body\">");
			out.print("    <a"
					+ (style == null ? "" : " class=\"" + style + "\"") + ">");

		} catch (IOException e) {
			throw new JspException(e.toString());
		}

		// getJspBody().invoke(sw);
		// out.println(sw.toString());

		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.print("     </a>");
			out.print("   </div>");
			out.print("   <div class=\"panel-footer\">");
			out.print("     <span class=\"glyphicon glyphicon-minus\"></span>");
			out.print("   </div>");
			out.print("</div>");

		} catch (Exception e) {
			throw new JspException(e.toString());
		}
		return EVAL_PAGE;
	}

	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}

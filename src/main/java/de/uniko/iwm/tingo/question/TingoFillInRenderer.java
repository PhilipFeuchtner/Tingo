package de.uniko.iwm.tingo.question;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TingoFillInRenderer extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4313973045806264100L;
	StringWriter sw = new StringWriter();

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<h2>FillInRenderer</h2>");
		} catch (IOException e) {
			throw new JspException(e.toString());
		}

		// getJspBody().invoke(sw);
		// out.println(sw.toString());

		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print("Hello from JSP!");
		} catch (Exception e) {
			throw new JspException(e.toString());
		}
		return EVAL_PAGE;
	}
}

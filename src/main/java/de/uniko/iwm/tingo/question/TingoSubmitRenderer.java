package de.uniko.iwm.tingo.question;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TingoSubmitRenderer extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4313973045806264100L;

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<ul class=\"nav nav-pills nav-stacked\">");
			out.println("  <li class=\"active\"><a id=\"qp_link\" class=\"tingo-submit\" href=\"#\">");
			out.println("    <span id=\"qp_badge\" class=\"badge pull-right\">qp_badge</span>");
			out.println("    <button id=\"qp_submit\" type=\"button\" class=\"btn btn-default\">Submit</button>");
			out.println("    <span id=\"qp_text\">qp_text</span>");
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
			out.println("  </a></li>");
			out.println("</ul>");
		} catch (Exception e) {
			throw new JspException(e.toString());
		}
		return EVAL_PAGE;
	}
}



		
		


package com.marmoush.javaexamples.ocejwcd.chp18.classic;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MyBodyTag extends BodyTagSupport {

    private static final long serialVersionUID = 1050128122117618914L;

    public int doStartTag() {
	BodyContent bodyCont = getBodyContent();
	if (bodyCont == null)
	    System.out.println("Body Content is null in doStartTag");
	return EVAL_BODY_BUFFERED;
    }

    @Override
    public void doInitBody() throws JspException {
	try {
	    BodyContent bodyCont = getBodyContent();
	    JspWriter out = bodyCont.getEnclosingWriter();
	    String data = bodyCont.getString();
	    if (data == null)
		out.println("Data here is null");
	    else
		if (data.length() == 0)
		    out.println("Data length is 0, which means body content not there yet");

	} catch (IOException e) {
	    throw new JspException(e);
	}

    }

    @Override
    public int doAfterBody() throws JspException {
	try {
	    // This code is generated for tags whose bodyContent is "JSP"
	    BodyContent bodyCont = getBodyContent();
	    // the commented code writes directly
	    // bodyCont.writeOut(bodyCont.getEnclosingWriter());
	    JspWriter out = bodyCont.getEnclosingWriter();
	    String data = bodyCont.getString();
	    out.println(data.toUpperCase());
	} catch (Exception e) {
	    throw new JspException(e);
	}
	return SKIP_BODY;
    }

}

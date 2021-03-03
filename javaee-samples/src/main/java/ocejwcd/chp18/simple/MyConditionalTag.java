package com.marmoush.javaexamples.ocejwcd.chp18.simple;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyConditionalTag implements SimpleTag {

    // STANDARD IMPLEMENTATION:

    private JspFragment body;
    private JspTag parent;
    private JspContext context;
    /* Instance- (rather than invocation-) specific 'test' attribute state */
    private boolean test;
    private JspFragment frag;

    public void doTag() throws JspException, java.io.IOException {
	/* Only execute ('invoke') the body if 'test' is true */
	if (test) {
	    /*
	     * Using an argument of null directs output to the 'out' implicit
	     * object by default
	     */

	    if (frag == null) System.out.println("fragment is already null");
	    frag.invoke(null);

	    body.invoke(null);
	}
    }

    public JspFragment getFrag() {
	return frag;
    }

    public JspTag getParent() {
	return parent;
    }

    public void setFrag(JspFragment frag) {
	this.frag = frag;
    }

    public void setJspBody(JspFragment fragment) {
	body = fragment;
    }

    public void setJspContext(JspContext context) {
	this.context = context;
    }

    public void setParent(JspTag parent) {
	this.parent = parent;
    }

    /**
     * Set the 'test' attribute for this instance (not invocation).
     */
    public void setTest(boolean test) {
	this.test = test;
    }
}
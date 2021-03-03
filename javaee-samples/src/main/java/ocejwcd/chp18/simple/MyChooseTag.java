package com.marmoush.javaexamples.ocejwcd.chp18.simple;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.JspException;

public class MyChooseTag extends SimpleTagSupport {

    /* Set to 'true' if a child tag has already evaluated */
    private boolean childInvoked;

    public void notifyChildInvoked() {
	childInvoked = true;
    }

    public boolean isChildInvoked() {
	return childInvoked;
    }

    public void doTag() throws JspException, java.io.IOException {
	childInvoked = false;
	/*
	 * Invoke the body once; this causes nested actions to be invoked
	 */
	getJspBody().invoke(null);
    }
}
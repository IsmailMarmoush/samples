package com.marmoush.javaexamples.ocejwcd.chp18.simple;

import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;

/**
 * A simple iteration tag which takes mandatory start and end attributes, and
 * optional step and var attributes. We iterate from start up to AND INCLUDING
 * 'end'.
 */
public class MyForTag extends SimpleTagSupport {

    private int start = 0;
    private int end = 0;
    private int step = 0;
    private String var;

    public void doTag() throws JspException, java.io.IOException {
	/* Check the attribute states - set step to 1 if it's still 0 */
	if (step == 0) {
	    step = 1;
	}

	/* Throw exception if this loop will never terminate */
	if ((step > 0 && start > end) || (step < 0 && start < end)) { throw new JspException(
	    "Illegal loop conditions: loop will never terminate"); }

	/* We implement our MyForTag as (strangely!) a for(...) loop */
	for (int counter = start; step > 0 ? counter <= end : counter >= end; counter += step) {

	    /*
	     * Sync. the counter, then invoke the body (with the new counter
	     * value), then update the counter ready for a new iteration
	     */
	    if (var != null) {
		getJspContext().setAttribute(var, new Integer(counter));
	    }

	    getJspBody().invoke(null);
	}

	/* Remove the attribute if it was originally bound */
	if (var != null) {
	    getJspContext().removeAttribute(var);
	}

	/*
	 * Don't need any other clean-up code here, since instances are never
	 * pooled (no need to reset instance variables)
	 */
    }

    /**
     * Set the 'end' attribute for this invocation.
     */
    public void setEnd(int end) {
	this.end = end;
    }

    /**
     * Set the 'start' attribute for this invocation.
     */
    public void setStart(int start) {
	this.start = start;
    }

    /**
     * Set the 'step' attribute for this invocation.
     */
    public void setStep(int step) {
	this.step = step;
    }

    /**
     * Set the 'var' attribute for this invocation.
     */
    public void setVar(String var) {
	this.var = var;
    }
}
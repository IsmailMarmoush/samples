package com.marmoush.javaexamples.ocejwcd.chp18.classic;

import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspException;

/**
 * A simple iteration tag which takes mandatory start and end attributes, and
 * optional step and var attributes. We iterate from start up to AND INCLUDING
 * 'end'.
 */
public class MyForTag extends TagSupport {

    private static final long serialVersionUID = -3580428270023251833L;
    /*
     * Iteration conditions - set by attributes. Each is 0 by default,
     * indicating it hasn't been explicitly set
     */
    private int start = 0;
    private int end = 0;

    /*
     * Note that 0 is an illegal value for 'step' - the loop would never end if
     * it's never incremented.
     */
    private int step = 0;

    /* null if not configured */
    private String var;

    /* Tag-local counter */
    private int counter;

    public int doAfterBody() {
	/* Increment the counter, check whether to go again */
	counter += step;
	syncCounter();
	return runLoop() ? EVAL_BODY_AGAIN : SKIP_BODY;
    }

    public int doEndTag() {
	/* Reset the attribute conditions */
	start = end = step = 0;

	/* Remove the attribute if it was originally bound */
	if (var != null) {
	    pageContext.removeAttribute(var);
	    var = null;
	}

	return EVAL_PAGE;
    }

    public int doStartTag() throws JspException {
	/* Check the attribute states - set step to 1 if it's still 0 */
	if (step == 0) {
	    step = 1;
	}

	/* Throw exception if this loop will never terminate */
	if ((step > 0 && start > end) || (step < 0 && start < end)) { throw new JspException(
	    "Illegal loop conditions: loop will never terminate"); }

	/* Set the counter to the start value */
	counter = start;

	syncCounter();

	/* Only include the body if we aren't at end already */
	return runLoop() ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }

    /** Determines whether to run another iteration */
    private boolean runLoop() {
	/*
	 * If step > 0, we are counting upwards so we have an UPPER limit. If
	 * step < 0, we are counting down so we have a LOWER limit.
	 */
	return step > 0 ? counter <= end : counter >= end;
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

    /** Updates the scoped counter variable, if required */
    private void syncCounter() {
	if (var != null) {
	    pageContext.setAttribute(var, new Integer(counter));
	}
    }

}
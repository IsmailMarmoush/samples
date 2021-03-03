package com.marmoush.javaexamples.ocejwcd.chp18.classic;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class MyConditionalTag implements Tag {

    private PageContext pageContext;
    private Tag parent;

    /* Invocation-specific 'test' attribute state */
    private boolean test;

    public int doEndTag() {

	/* No processing required */
	return EVAL_PAGE;
    }

    public int doStartTag() {

	/* Only include the body if 'test' is true */
	return test ? EVAL_BODY_INCLUDE : SKIP_BODY;
    }

    public PageContext getPageContext() {
	return pageContext;
    }

    public Tag getParent() {
	return parent;
    }

    public void release() {
	// No resources to release
    }

    public void setPageContext(PageContext pc) {
	pageContext = pc;
    }

    public void setParent(Tag t) {
	parent = t;
    }

    /**
     * Set the 'test' attribute for this invocation.
     */
    public void setTest(boolean test) {
	this.test = test;
    }
}
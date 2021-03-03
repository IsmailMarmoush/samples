package com.marmoush.javaexamples.ocejwcd.chp18.classic;

import java.util.Locale;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspException;

/**
 * An empty tag which produces an HTML drop-down box containing a list of all
 * countries installed in java.util.Locale. The optional 'lang' attribute
 * controls the language in which the countries are shown (default "en"). The
 * optional 'select' attribute specifies the ISO country code of the country to
 * select by default. This tag also takes dynamic attributes, which are passed
 * through to the HTML <select> tag unmodified.
 */
public class SelectCountryTag extends TagSupport implements DynamicAttributes {

    /*
     * 'lang' attribute indicating the ISO language code in which country names
     * are displayed; default value is null (indicating "en")
     */
    private String lang;

    /*
     * 'select' attribute indicating the ISO country code which will be selected
     * by default; default value is null.
     */
    private String select;

    /*
     * Note that 0 is an illegal value for 'step' - the loop would never end if
     * it's never incremented.
     */
    private Locale[] locales;

    /*
     * This is a cache - 'locales' will only be modified between invocations if
     * the 'lang' country code changes
     */
    private String lastCountryCache;

    /* Dynamic attributes buffer */
    private StringBuffer dynattrs = new StringBuffer();

    /**
     * Set the 'lang' attribute for this invocation.
     */
    public void setLang(String lang) {
	this.lang = lang;
    }

    /**
     * Set the 'select' attribute for this invocation.
     */
    public void setSelect(String select) {
	this.select = select;
    }

    /**
     * Sets the dynamic attributes. Since these are passed through to the HTML
     * <select> unchanged, we simply store them in a buffer.
     */
    public void setDynamicAttribute(String uri, String localName, Object value) {
	dynattrs.append(uri == null ? "" : uri + ":");
	dynattrs.append(localName + "=\"" + value + "\" ");
    }

    private void loadLocales() {
	/*
	 * If this tag was executed before (i.e. when lastCountryCode != null),
	 * and the cache is equal to the new language, don't bother updating the
	 * Locale[]
	 */
	if ((lastCountryCache != null) && lastCountryCache.equals(lang)) { return; }

	/* Otherwise update locales */
	String[] isoCountries = Locale.getISOCountries();
	locales = new Locale[isoCountries.length];
	for (int i = 0; i < isoCountries.length; i++) {
	    locales[i] = new Locale(lang, isoCountries[i]);
	}

	/* Now sort the list - we want it sorted by display name */
	java.util.Comparator<Locale> compare = new java.util.Comparator<Locale>() {

	    /* Guaranteed to be Locales by generics */
	    public int compare(Locale l1, Locale l2) {
		return l1.getDisplayCountry(l1).compareTo(
		    l2.getDisplayCountry(l2));
	    }

	    public boolean equals(Object obj) {
		/* Don't care - return false */
		return false;
	    }

	};

	/* Using generics with arguments (Locale[], Comparator<Locale>) */
	java.util.Arrays.sort(locales, compare);
    }

    public int doStartTag() {
	/* If 'lang' was not specified, default to "en" */
	if (lang == null) {
	    lang = "en";
	}

	/* Configure the Locale[] using the language of choice */
	loadLocales();

	/* This is an empty element: always skip the body */
	return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
	/* Write out the opening <select> tag */
	try {
	    java.io.Writer out = pageContext.getOut();
	    out.write("<select " + dynattrs + ">\n");

	    /* Write out the <option> tags */
	    for (Locale l : locales) {
		/*
		 * The name attribute of <option> is used for HTML form
		 * submission
		 */
		out.write("<option name=\"" + l.getCountry() + "\"");
		/* Select this option only if it matches the 'select' attribute */
		out.write((select != null && select.equals(l.getCountry())) ? " selected=\"selected\"" : "");
		out.write(">" + l.getDisplayCountry(l) + "</option>\n");
	    }

	    /* Write the closing tag */
	    out.write("</select>\n");
	} catch (java.io.IOException ioe) {
	    throw new JspException(ioe);
	} finally {
	    /* Cache this country */
	    lastCountryCache = lang;

	    /* Reset attributes and dynamic attributes buffer */
	    lang = select = null;
	    dynattrs.delete(0, dynattrs.length());
	}

	return EVAL_PAGE;
    }

}
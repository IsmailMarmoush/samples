package com.marmoush.javaexamples.ocejwcd.chp05;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;
import javax.persistence.PersistenceUnit;
import javax.persistence.PersistenceUnits;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@PersistenceUnits(value=@PersistenceUnit(name="blabla",unitName=""))
@WebServlet("/ocejwcd/chp05/requestservlet/*")
public class RequestServlet extends HttpServlet {

    private static final long serialVersionUID = -3993800951546146955L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	resp.getWriter().println("Request URI: " + req.getRequestURI());
	resp.getWriter().println("Request URL: " + req.getRequestURL());
	resp.getWriter().println("QueryString: " + req.getQueryString());
	resp.getWriter().println("ServletPath: " + req.getServletPath());
	resp.getWriter().println(" ------------");
	resp.getWriter().write("hello");
	resp.getWriter().write("hi");
	Enumeration<String> parameterNames = req.getParameterNames();
	while (parameterNames.hasMoreElements()) {
	    String paramName = (String) parameterNames.nextElement();
	    resp.getWriter().println("ParamName=" + paramName);
	    String[] parameterValues = req.getParameterValues("names");
	    if (parameterValues != null) {
		for (String val : parameterValues) {
		    resp.getWriter().println(val);
		}
	    }
	}
	
	AuthenticationType application = Resource.AuthenticationType.APPLICATION;
	
	resp.flushBuffer();
	String k = null;
	System.out.println(k);
	// has no effect because it was called after getWriter
	resp.setLocale(Locale.US);
    }
}

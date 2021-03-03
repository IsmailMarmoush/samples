package com.marmoush.javaexamples.servletspecs3.chp03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/servletspecs3/chp03/requestpathelement/*" })
public class RequestPathElements extends HttpServlet {

    private static final long serialVersionUID = 3786978149139556847L;

    @SuppressWarnings("deprecation")
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	PrintWriter out = resp.getWriter();

	// requestURI = contextPath + servletPath + pathInfo
	String requestURI = req.getRequestURI();
	out.println("RequestURI: " + requestURI);

	String contextPath = req.getContextPath();
	out.println("contextPath: " + contextPath);

	String servletPath = req.getServletPath();
	out.println("servletPath: " + servletPath);

	String pathInfo = req.getPathInfo();
	out.println("PathInfo: " + pathInfo);

	// Path TranslationMethods
	out.println("Deprecated getRealPath(RequestURI): "
		+ req.getRealPath(requestURI));
	out.println("getServletContext.getRealPath(RequestURI): "
		+ req.getServletContext().getRealPath(requestURI));
	out.println("PathTranslated: " + req.getPathTranslated());
    }
}

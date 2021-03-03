package com.marmoush.javaexamples.servletspecs3.chp04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/servletspecs3/chp04/contextattribute2" })
public class ContextAttribute2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	PrintWriter out = resp.getWriter();

	/*
	 * Must call /chp4/contextattribute1 first
	 */

	// using direct getservletcon
	ServletContext sc = getServletContext();
	String myName = (String) sc.getAttribute("myName");
	out.println(myName);

	// using getservletconfig.getservletcontext
	ServletContext sc2 = getServletConfig().getServletContext();
	String myName2 = (String) sc2.getAttribute("myName");
	out.println(myName2);

	// get message from context listener
	ServletContext sc3 = getServletContext();
	out.println(sc3.getAttribute("fromListener"));

    }
}

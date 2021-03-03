package com.marmoush.javaexamples.servletspecs3.chp04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/servletspecs3/chp04/contextattribute1" })
public class ContextAttribute1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	ServletContext sc = getServletContext();
	sc.setAttribute("myName", "ismail");

	PrintWriter out = resp.getWriter();
	out.println(sc.getAttribute("myName"));

    }
}

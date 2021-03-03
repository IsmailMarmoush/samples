package com.marmoush.javaexamples.servletspecs3.chp05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/servletspecs3/chp05/headers" })
public class Headers extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	out.println("SETTING RESPONSE HEADERS ");

	resp.setHeader("whatever", "first value");
	resp.addHeader("whatever", "second value");

	// Using Request Class
	out.println(" Using Request Class");
	out.println("The First Value: " + req.getHeader("whatever"));
	Enumeration<String> values = req.getHeaders("whatever");
	out.print("All Values: ");
	while (values.hasMoreElements()) {
	    String val = values.nextElement();
	    out.print(val + "   ");
	}
	out.println(" ");
	out.println("-------------------------------------");

	// Using Response Class
	out.println(" Using Response Class");
	out.println("The First Value: " + resp.getHeader("whatever"));
	Collection<String> respvalues = resp.getHeaders("whatever");
	out.print("All Values: ");
	for (String val : respvalues) {
	    out.print(val);
	}
	out.println(" ");
	out.println("-------------------------------------");
    }
}

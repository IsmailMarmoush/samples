package com.marmoush.javaexamples.hfbook.chp4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hfbook/chp4/streams" })
public class Streams extends HttpServlet {
    private static final long serialVersionUID = -5977624052842629093L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	/*
	 * Inside the servlet response, when you ask for the PrintWriter, it's
	 * going to do the following... Look up appropriate encoding from
	 * content type (most likely ISO-8859-1 unless otherwise specified).
	 * 
	 * String encoding = ...;
	 * 
	 * return new PrintWriter( new OutputStreamWriter( servletOutputStream,
	 * encoding ) );
	 */
	ServletOutputStream sos = resp.getOutputStream();
	sos.print("hello world\n");
	sos.print("hi");
	sos.flush();
    }
}

package com.marmoush.javaexamples.ocejwcd.chp05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ocejwcd/chp05/encode")
public class Encode extends HttpServlet {

    private static final long serialVersionUID = 7283975408768786798L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {

	String encodeURL = resp.encodeURL("/asdgoogle");
	resp.sendRedirect("http://google.com");
	// adsfasd
	resp.getWriter().write(encodeURL);
    }
}

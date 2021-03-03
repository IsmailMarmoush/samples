package com.marmoush.javaexamples.ocejwcd.chp03;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ocejwcd/chp03")
public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 4209236187182964271L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
	throws IOException {
	// TODO Auto-generated method stub

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	resp.getWriter().write("hello from servlet at chapter 3");

    }
}

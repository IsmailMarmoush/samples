package com.marmoush.javaexamples.servletspecs3.chp09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletspecs3/chp09/forwardservlet")
public class ForwardServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	PrintWriter out = resp.getWriter();
	out.println("this will cause IllegalStateException in the console ");
	out.flush();

	RequestDispatcher rd = req.getRequestDispatcher("Receiver");
	req.setAttribute("hello", "from forward");
	rd.forward(req, resp);
    }
}

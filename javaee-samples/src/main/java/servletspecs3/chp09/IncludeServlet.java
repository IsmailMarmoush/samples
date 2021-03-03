package com.marmoush.javaexamples.servletspecs3.chp09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IncludeServlet
 */
@WebServlet("/servletspecs3/chp09/includeservlet")
public class IncludeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	out.println("before include method");
	request.setAttribute("hello", "include");
	RequestDispatcher rd = request.getRequestDispatcher("Receiver");
	rd.include(request, response);
	out.println("after include method");
    }

}

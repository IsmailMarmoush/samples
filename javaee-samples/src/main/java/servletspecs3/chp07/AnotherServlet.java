package com.marmoush.javaexamples.servletspecs3.chp07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnotherServlet
 */
@WebServlet("/servletspecs3/chp07/anotherservlet")
@WebInitParam(name = "hello", value = "hi")
public class AnotherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	PrintWriter out = response.getWriter();
	out.println(session.getAttribute("name"));
	out.println(session.getMaxInactiveInterval());
    }

}

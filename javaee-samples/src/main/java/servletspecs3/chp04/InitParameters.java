package com.marmoush.javaexamples.servletspecs3.chp04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParameters
 */
@WebServlet(urlPatterns = { "/servletspecs3/chp04/initparameters" }, initParams = {
	@WebInitParam(name = "webmasterEmail", value = "marmoushismail@gmail.com"),
	@WebInitParam(name = "firstName", value = "Ismail", description = "Web Master First Name") })
public class InitParameters extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	ServletContext sc = request.getServletContext();

	Enumeration<String> names = sc.getInitParameterNames();
	while (names.hasMoreElements()) {
	    String name = names.nextElement();

	    String value = sc.getInitParameter(name);
	    out.println(name);
	    out.println("NAME: " + name + " Value: " + value);
	}
	out.println(getInitParameter("webmasterEmail"));
    }

}

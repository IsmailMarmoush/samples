package com.marmoush.javaexamples.hfbook.chp5;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hfbook/chp5/initparams", initParams = {
	@WebInitParam(name = "title", value = "Temperature Converter Result"),
	@WebInitParam(name = "param2", value = "value2") })
public class InitParams extends HttpServlet {
    private static final long serialVersionUID = 1307863054637966219L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	/*
	 * DD elements <context-param> and <init-param> both can be retrieved by
	 * the getInitParameter() method, in the servlet code.
	 * 
	 * Servlet init parameters are for a single servlet only. No body out
	 * side that servlet can access that. It is declared inside the
	 * <servlet> tag inside Deployment Descriptor, on the other hand context
	 * init parameter is for the entire web application. Any servlet or JSP
	 * in that web application can access context init parameter. Context
	 * parameters are declared in a tag <context-param> directly inside the
	 * <web-app> tag.
	 * 
	 * The methods for accessing context init parameter is
	 * getServletContext().getInitParamter("name").
	 */
	ServletContext servletContext = req.getServletContext();
	String parameter = servletContext.getInitParameter("hi");
	if (parameter != null)
	    resp.getWriter().write(parameter);
	resp.getWriter().write("\n");

	/*
	 * Whereas method for accessing servlet init parameter is
	 * getServletConfig().getInitParamter("name").
	 */
	String initParameter = getServletConfig().getInitParameter("title");
	if (initParameter != null)
	    resp.getWriter().write(initParameter);
    }

}

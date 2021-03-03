package com.marmoush.javaexamples.ocejwcd.chp08.ex2;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = { "/shoutServletAsync" })
public class ShoutServletAsync extends HttpServlet {
    private static final long serialVersionUID = 4609749667818389944L;

    @Override
    protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
	String name = request.getParameter("name");
	String message = request.getParameter("message");
	String htmlMessage = "<p><b>" + name + "</b><br/>" + message + "</p>";
	ServletContext sc = request.getServletContext();
	if (sc.getAttribute("messages") == null) {
	    sc.setAttribute("messages", htmlMessage);
	} else {
	    String currentMessages = (String) sc.getAttribute("messages");
	    sc.setAttribute("messages", htmlMessage + currentMessages);
	}
	response.sendRedirect("async.jsp");
    }
}
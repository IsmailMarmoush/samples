package com.marmoush.javaexamples.ocejwcd.chp08.ex2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = { "/shoutServletAsync2" }, asyncSupported = true)
public class ShoutServletAsync2 extends HttpServlet {
    private static final long serialVersionUID = 7288991827356853993L;
    private List<AsyncContext> contexts = new LinkedList<>();

    @Override
    protected void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
	final AsyncContext asyncContext = request.startAsync(request, response);
	asyncContext.setTimeout(10 * 60 * 1000);
	contexts.add(asyncContext);
    }

    @Override
    protected void doPost(HttpServletRequest request,
	HttpServletResponse response) throws ServletException, IOException {
	List<AsyncContext> asyncContexts = new ArrayList<>(this.contexts);
	this.contexts.clear();
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
	for (AsyncContext asyncContext : asyncContexts) {
	    try (PrintWriter writer = asyncContext.getResponse().getWriter()) {
		writer.println(htmlMessage);
		writer.flush();
		asyncContext.complete();
	    } catch (Exception ex) {}
	}

    }
}
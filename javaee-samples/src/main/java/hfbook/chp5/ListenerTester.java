package com.marmoush.javaexamples.hfbook.chp5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hfbook/chp5/listenertester")
public class ListenerTester extends HttpServlet {

    private static final long serialVersionUID = -7957084071471171397L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	pw.println("Test context Attributes set by listener <br/>");
	Dog d = (Dog) getServletContext().getAttribute("dog");
	pw.println("Dog breed is " + d.getBreed());
    }
}

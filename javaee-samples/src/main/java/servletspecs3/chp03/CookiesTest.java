package com.marmoush.javaexamples.servletspecs3.chp03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/servletspecs3/chp03/cookiestest/*" })
public class CookiesTest extends HttpServlet {

    private static final long serialVersionUID = -2993550127867801626L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();

	Cookie cookie = new Cookie("mycookie", "hi");
	resp.addCookie(cookie);

	cookie.setHttpOnly(true);
	boolean bol = cookie.isHttpOnly();
	out.println("<br>Cookie is Marked as HttpOnly = " + bol);
	Cookie[] cookies = req.getCookies();
	if (cookies != null) {
	    for (int i = 0; i < cookies.length; i++) {
		out.println("<br/> From Cookies Array Name is: "
			+ cookies[i].getName());
		out.println("<br/> From Cookies Array Value is: "
			+ cookies[i].getValue());
		out.println("<br/> From Cookies Array isHttpOnly: "
			+ cookies[i].isHttpOnly());
	    }
	}
	out.println("<br/> <br/>");

	cookie.setHttpOnly(false);
	boolean bol1 = cookie.isHttpOnly();
	out.println("<br>Cookie is Marked as HttpOnly = " + bol1);
	Cookie[] cookies1 = req.getCookies();
	if (cookies1 != null) {
	    for (int i = 0; i < cookies1.length; i++) {
		out.println("<br/> From Cookies Array Name is: "
			+ cookies[i].getName());
		out.println("<br/> From Cookies Array Value is: "
			+ cookies[i].getValue());
		out.println("<br/> From Cookies Array isHttpOnly: "
			+ cookies[i].isHttpOnly());
	    }
	}
	out.close();
    }
}

package com.marmoush.javaexamples.ocejwcd.chp06;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ocejwcd/chp06/dispatchedservlet")
@MultipartConfig()
public class DispatchedServlet extends HttpServlet{
	private static final long serialVersionUID = -4476502084598807040L;
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().write("hello world from");
		resp.getWriter().write("Dispatched servlet");
		resp.flushBuffer();
		resp.setStatus(resp.SC_NOT_FOUND);
		
		System.out.println("dsaf"+null);
		getServletConfig().getServletContext();
		getServletContext();
		
	}
	
	void bla(){
	    
	}
}

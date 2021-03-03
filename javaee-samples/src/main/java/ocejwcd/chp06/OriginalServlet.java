package com.marmoush.javaexamples.ocejwcd.chp06;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ocejwcd/chp06/originalservlet")
public class OriginalServlet extends HttpServlet {
	private static final long serialVersionUID = 7232659634476801938L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setBufferSize(0);

		resp.getWriter().write("Hello from");
		resp.getWriter().write("original servlet\n");
		// resp.getWriter().flush();
		//
		RequestDispatcher requestDispatcher = req
				.getRequestDispatcher("/ocejwcd/chp06/dispatchedservlet");

		if (requestDispatcher != null)
			System.out.println("req is not null");

		// resp.getWriter().flush();
		// resp.flushBuffer();
		requestDispatcher.forward(req, resp);

		resp.getWriter().write("original servlet after forward/include <br/>");
		System.out.println("after foward");
		// doesn't throw anything even after
		// resp.setStatus(resp.SC_NOT_FOUND);

		// Raises illegalstateexception
		// resp.sendRedirect("http://	hotmail.com");
	}

}

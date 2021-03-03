package com.marmoush.javaexamples.servletspecs3.chp03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "httpprotocol", urlPatterns = { "/servletspecs3/chp03/httpprotocol" })
public class HttpProtocolParams extends HttpServlet {

    private static final long serialVersionUID = -113226272438309756L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	// String realPath = getServletContext().getRealPath("/");
	// String fileSep = System.getProperty("file.separator");
	// if (realPath != null && (!realPath.endsWith(fileSep))) {
	// realPath = realPath + fileSep;
	// }
	// // req.getQueryString();
	// JClassLogger out = new JClassLogger(realPath + "WEB-INF" + fileSep
	// + "classes" + fileSep, null);
	// out.log(Level.INFO, req.getQueryString());
	// out.log(Level.ALL, "hello");

	PrintWriter out = resp.getWriter();

	out.write("getRequestURI: " + req.getRequestURI());
	out.write("\n");
	out.write("getPathInfo: " + req.getPathInfo());
    }
}

package com.marmoush.javaexamples.servletspecs3.chp05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/servletspecs3/chp05/buffering" })
public class Buffering extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	resp.setBufferSize(8 * 1024); // 8K buffer
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	// returns 8096 or greater
	int size = resp.getBufferSize();

	// Record the default size, in the log
	log("The default buffer size is " + size);

	out.println("The client won't see this");
	resp.reset();
	out.println("And this won't be seen if sendError() is called");
	out.println(resp.getBufferSize());

	if (req.getParameter("important_parameter") == null) {
	    resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
		    "important_parameter needed");
	}
	// resp.setHeader("Content-length", "" + fileLength);
	// resp.setContentType("application/vnd.ms-excel");
	// resp.setHeader("Content-Disposition","attachment; filename=\"export.csv\"");
	//
	// FileInputStream inputStream = null;
	//
	// try
	// {
	// inputStream = new FileInputStream(path);
	// byte[] buffer = new byte[1024];
	// int bytesRead = 0;
	//
	// do
	// {
	// bytesRead = inputStream.read(buffer, offset, buffer.length);
	// resp.getOutputStream().write(buffer, 0, bytesRead);
	// }
	// while (bytesRead == buffer.length);
	//
	// resp.getOutputStream().flush();
	// }
	// finally
	// {
	// if(inputStream != null)
	// inputStream.close();
	// }

    }
}

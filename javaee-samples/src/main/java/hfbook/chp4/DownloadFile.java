package com.marmoush.javaexamples.hfbook.chp4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hfbook/chp4/downloadfile" })
public class DownloadFile extends HttpServlet {
    private static final long serialVersionUID = -8291560391406747528L;
    private static final int BYTES_DOWNLOAD = 1024;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws IOException {
	response.setContentType("application/pdf");
	response.setHeader("Content-Disposition",
		"attachment;filename=book.pdf");
	ServletContext ctx = getServletContext();
	InputStream is = ctx.getResourceAsStream("/Chrome.pdf");

	int read = 0;
	byte[] bytes = new byte[BYTES_DOWNLOAD];
	OutputStream os = response.getOutputStream();

	while ((read = is.read(bytes)) != -1) {

	    os.write(bytes, 0, read);
	}
	os.flush();
	os.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	resp.getWriter().write("hello dddworld");
    }
}

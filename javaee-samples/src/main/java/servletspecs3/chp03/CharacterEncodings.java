package com.marmoush.javaexamples.servletspecs3.chp03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletspecs3/chp03/characterencoding")
public class CharacterEncodings extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	out.println(request.getCharacterEncoding());
	/*
	 * It must be called prior to parsing any post data or reading any input
	 * from the request. Calling this method once data has been read will
	 * not affect the encoding.
	 */
	request.setCharacterEncoding("utf-8");
	out.println(request.getCharacterEncoding());
    }
}

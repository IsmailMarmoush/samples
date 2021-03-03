package com.marmoush.javaexamples.hfbook.chp4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tracing
 */
@WebServlet("/hfbook/chp4/tracing")
public class Tracing extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doTrace(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	/*
	 * http://www.coderanch.com/t/176030/java-Web-Component-SCWCD/certification
	 * /doTrace-method
	 * 
	 * The TRACE HTTP method is designed as a debug feature as follows:
	 * whatever you send the remote server as an HTTP request, the remote
	 * server will loop-back that data and send it all back to you. That
	 * allows you to see if it is receiving all the data it should (e.g.
	 * that data isn't being corrupted by a proxy). It could, in theory, be
	 * used as a first step towards debugging a Web application if you think
	 * your application is going wrong because it isn't receiving the
	 * correct headers - however, I don't think I've ever used it in
	 * practise because it's only marginally more difficult to get the Web
	 * app itself to output the headers it receives to a log (e.g. by
	 * addition of a Filter). Also it has been found that a server which
	 * allows TRACE has a minor security flaw (see Cross-Site Tracing
	 * Issues) so many admins disable it for that reason.
	 * 
	 * There's also a handy script online that will show you the results of
	 * a TRACE: http://schroepl.net/cgi-bin/http_trace.pl .
	 * 
	 * Note: You won't be expected to know anything (significant) about
	 * TRACE for the SCWCD!
	 */
    }

}

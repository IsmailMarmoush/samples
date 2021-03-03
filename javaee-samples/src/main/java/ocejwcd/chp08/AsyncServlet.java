package com.marmoush.javaexamples.ocejwcd.chp08;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.AsyncContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/ocejwcd/chp08/asyncservlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    private static final long serialVersionUID = -5675867608146739125L;

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
	final AsyncContext ctx = req.startAsync();
	ctx.start(new Runnable() {
	    public void run() {
		try {
		    String msg = MessageFormat.format(
			"<h1>Processing task in background thread id:[{0}]</h1>",
			Thread.currentThread().getId());

		    ctx.getResponse().getWriter().write(msg);
		} catch (IOException e) {
		    log("Problem processing task", e);
		}
		ctx.complete();
	    }
	});
    }
}
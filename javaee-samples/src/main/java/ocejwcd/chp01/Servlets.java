package com.marmoush.javaexamples.ocejwcd.chp01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlets extends HttpServlet {

    private static final long serialVersionUID = -2957575391567619467L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	Cookie[] cookies = req.getCookies();

	super.doGet(req, resp);
    }
}

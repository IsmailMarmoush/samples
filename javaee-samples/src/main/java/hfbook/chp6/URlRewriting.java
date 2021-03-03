package com.marmoush.javaexamples.hfbook.chp6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hfbook/chp6/urlrewriting")
public class URlRewriting extends HttpServlet {
    private static final long serialVersionUID = 4767258889402518283L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {
	resp.encodeRedirectURL("/hfbook/chp5/initparams");
    }
}

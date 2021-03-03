package com.marmoush.javaexamples.ocejwcd.chp22;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ocejwcd/logout")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = -6035547810961025135L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	req.logout();
	resp.getWriter().write("You're now logged out");

    }
}

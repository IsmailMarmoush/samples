package com.marmoush.javaexamples.ocejwcd.chp22;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ocejwcd/securitytest")
public class SecurityTest extends HttpServlet {

    private static final long serialVersionUID = 1840150658110115042L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	resp.getWriter().write("Authorized login!!!");
    }
}

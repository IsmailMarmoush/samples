package com.marmoush.javaexamples.ocejwcd.chp22;

import java.io.IOException;

import javax.annotation.security.DeclareRoles;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@DeclareRoles(
    value = { "Clients","hello" })
@WebServlet("/ocejwcd/checkroles")
public class CheckRoles extends HttpServlet {
    private static final long serialVersionUID = 7037480725267107341L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	if (req.isUserInRole("Clients"))
	    resp.getWriter().write("User is in Role Customers");
	else
	    resp.getWriter().write("User is not in Role");
    }
}

package com.marmoush.javaexamples.ocejwcd.chp12;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ocejwcd/chp12/jndi")
public class JNDIServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public JNDIServlet() {
    }

    /**
     * use test;
     * 
     * "insert into student (student_id,first_name,age) values ('2', 'mona',23),('3', 'islam',22 ),('4','ramy',20);"
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	Context envContext = null;
	try {
	    envContext = new InitialContext();
	    // Context initContext = (Context)
	    // envContext.lookup("java:/comp/env");
	    // DataSource ds = (DataSource) initContext.lookup("jdbc/testdsn");
	    DataSource ds = (DataSource) envContext.lookup("jdbc/testdsn");
	    Connection con = ds.getConnection();

	    Statement stmt = con.createStatement();
	    String query = "select * from student";
	    ResultSet rs = stmt.executeQuery(query);

	    PrintWriter out = response.getWriter();
	    response.setContentType("text/html");
	    out.print("<center><h1>Student Details</h1></center>");
	    out.print("<html><body><table border=\"1\" cellspacing=10 cellpadding=5>");
	    out.print("<th>Student ID</th>");
	    out.print("<th>Student Name</th>");
	    out.print("<th>Age </th>");
	    out.print("<th>Department</th>");

	    while (rs.next()) {
		out.print("<tr>");
		out.print("<td>" + rs.getInt("student_id") + "</td>");
		out.print("<td>" + rs.getString("first_name") + "</td>");
		out.print("<td>" + rs.getInt("age") + "</td>");
		out.print("</tr>");
	    }
	    out.print("</table></body></html>");
	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (NamingException e) {
	    e.printStackTrace();
	}
    }
}
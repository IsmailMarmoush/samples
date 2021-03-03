package com.marmoush.javaexamples.servletspecs3.chp04;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class RegisterServlets implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void contextInitialized(ServletContextEvent event) {

	ServletContext sc = event.getServletContext();
	ServletRegistration sr = sc.addServlet("runtimeservlet",
		RuntimeServlet.class);
	sr.setInitParameter("name1", "value1");
	sr.addMapping("/chp4/runtimeservlet");
    }
}

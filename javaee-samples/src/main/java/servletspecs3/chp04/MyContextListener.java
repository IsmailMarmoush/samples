package com.marmoush.javaexamples.servletspecs3.chp04;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
	ServletContext sc = sce.getServletContext();
	sc.setAttribute("fromListener",
		"this message was set by context listener");
    }

}

package com.marmoush.javaexamples.hfbook.chp5;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
	Dog d = new Dog("husky");
	sce.getServletContext().setAttribute("dog", d);
    }

}

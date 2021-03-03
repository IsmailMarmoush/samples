package com.marmoush.javaexamples;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.websocket.server.ServerEndpointConfig;

import com.marmoush.javaexamples.asyncwebsocket.EchoEndpoint;

public class MyContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context initialized");
		ServerEndpointConfig.Builder.create(EchoEndpoint.class, "/echo")
				.build();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}

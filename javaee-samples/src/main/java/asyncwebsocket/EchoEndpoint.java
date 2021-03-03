package com.marmoush.javaexamples.asyncwebsocket;

import java.io.IOException;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class EchoEndpoint extends Endpoint {
	@Override
	public void onOpen(final Session session, EndpointConfig config) {
		System.out.println("opened endpoint");
		session.addMessageHandler(new MessageHandler.Whole<String>() {
			@Override
			public void onMessage(String msg) {
				try {
					System.out.println("Message received at endpoint");
					session.getBasicRemote().sendText(msg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
package com.marmoush.javaexamples.asynchrnous.async2;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// enable async in the servlet
@WebServlet(urlPatterns = "/test", asyncSupported = true)
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 2351783122616088149L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		// start async
		AsyncContext ac = req.startAsync();
		// set up async listener
		ac.addListener(new AsyncListener() {
			public void onComplete(AsyncEvent event) throws IOException {
				event.getSuppliedResponse().getOutputStream().print("Complete");
			}

			public void onError(AsyncEvent event) {
				System.out.println(event.getThrowable());
			}

			public void onStartAsync(AsyncEvent event) {
			}

			public void onTimeout(AsyncEvent event) {
				System.out.println("my asyncListener.onTimeout");
			}
		});

		// set up ReadListener to read data for processing
		ServletInputStream input = req.getInputStream();
		ReadListener readListener = new ReadListenerImpl(input, res, ac);
		input.setReadListener(readListener);
	}
}
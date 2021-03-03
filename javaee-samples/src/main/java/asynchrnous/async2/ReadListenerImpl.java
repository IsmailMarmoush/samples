package com.marmoush.javaexamples.asynchrnous.async2;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.AsyncContext;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;

/**
 * @see <a href=
 * "https://weblogs.java.net/blog/swchan2/archive/2013/04/16/non-blocking-io-servlet-31-example"
 * >reference </a>
 * 
 * @author tesla
 * 
 */
class ReadListenerImpl implements ReadListener {
	private ServletInputStream input = null;
	private HttpServletResponse res = null;
	private AsyncContext ac = null;
	// store the processed data to be sent back to client later
	private Queue<String> queue = new LinkedBlockingQueue<String>();

	ReadListenerImpl(ServletInputStream in, HttpServletResponse r,
			AsyncContext c) {
		input = in;
		res = r;
		ac = c;
	}

	public void onDataAvailable() throws IOException {
		StringBuilder sb = new StringBuilder();
		int len = -1;
		byte b[] = new byte[1024];
		// We need to check input#isReady before reading data.
		// The ReadListener will be invoked again when
		// the input#isReady is changed from false to true
		while (input.isReady() && (len = input.read(b)) != -1) {
			String data = new String(b, 0, len);
			sb.append(data);
		}
		queue.add(sb.toString());
	}

	public void onAllDataRead() throws IOException {
		// now all data are read, set up a WriteListener to write
		ServletOutputStream output = res.getOutputStream();
		WriteListener writeListener = new WriteListenerImpl(output, queue, ac);
		output.setWriteListener(writeListener);
	}

	public void onError(final Throwable t) {
		ac.complete();
		t.printStackTrace();
	}
}
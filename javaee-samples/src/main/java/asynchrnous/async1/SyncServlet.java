package com.marmoush.javaexamples.asynchrnous.async1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/async1/sync")
public class SyncServlet extends HttpServlet {
    private static final long serialVersionUID = -665341751802536093L;
    public static final long SLEEP = 500;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	/*
	 * I'm using thread here even that I don't need to, because I wanted to
	 * make both servlets run a different thread other than what they're
	 * currently in, just to make sure situation is matched as mush as
	 * possible
	 */
	Thread d = new Thread(new Runnable() {
	    public void run() {
		try {
		    Thread.sleep(SLEEP);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}

	    }
	});
	d.run();
    }
}

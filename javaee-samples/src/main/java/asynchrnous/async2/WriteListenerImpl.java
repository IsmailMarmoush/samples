package com.marmoush.javaexamples.asynchrnous.async2;

import java.io.IOException;
import java.util.Queue;

import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

class WriteListenerImpl implements WriteListener {
    private ServletOutputStream output = null;
    private Queue<String> queue = null;
    private AsyncContext ac = null;

    WriteListenerImpl(ServletOutputStream sos, Queue<String> q, AsyncContext c) {
        output = sos;
        queue = q;
        ac = c;
    }

    public void onWritePossible() throws IOException {
        // write while there is data and is ready to write
        while (queue.peek() != null && output.isReady()) {
            String data = queue.poll();
            output.print(data);
        }
        // complete the async process when there is no more data to write
        if (queue.peek() == null) {
            ac.complete();
        }
    }

    public void onError(final Throwable t) {
        ac.complete();
        t.printStackTrace();
    }
}
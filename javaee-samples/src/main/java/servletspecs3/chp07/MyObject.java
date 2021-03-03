package com.marmoush.javaexamples.servletspecs3.chp07;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MyObject implements HttpSessionBindingListener {
    private int i;
    private int k;

    public MyObject() {
    }

    public int getI() {
	return i;
    }

    public int getK() {
	return k;
    }

    public void setI(int i) {
	this.i = i;
    }

    public void setK(int k) {
	this.k = k;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
	HttpSession session = event.getSession();
	session.setAttribute("name", event.getName());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }

}

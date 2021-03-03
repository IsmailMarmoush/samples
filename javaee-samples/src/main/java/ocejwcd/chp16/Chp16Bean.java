package com.marmoush.javaexamples.ocejwcd.chp16;

import java.io.Serializable;

public class Chp16Bean implements Serializable {
    private static final long serialVersionUID = 8623770342356179694L;

    private String firstName;

    public Chp16Bean() {
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }
}

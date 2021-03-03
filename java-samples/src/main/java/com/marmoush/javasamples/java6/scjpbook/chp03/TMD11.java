package com.marmoush.javasamples.java6.scjpbook.chp03;

public class TMD11 {}

class Beta {}

class Alpha {
  static Beta b1;
  Beta b2;
}

class Tester {
  public static void main(String[] args) {
    Beta b1 = new Beta();
    Beta b2 = new Beta();
    Alpha a1 = new Alpha();
    Alpha a2 = new Alpha();
    a1.b1 = b1;
    a1.b2 = b1;
    a2.b2 = b2;
    a1 = null;
    b1 = null;
    b2 = null;
    // When this line is reached, how many objects will be eligible for
    // garbage collection?
  }
}

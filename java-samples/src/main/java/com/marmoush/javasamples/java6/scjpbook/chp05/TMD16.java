package com.marmoush.javasamples.java6.scjpbook.chp05;

class MyException extends Exception {}

class Tire {
  void doStuff() {}
}

public class TMD16 extends Tire {
  public static void main(String[] args) {
    new TMD16().doStuff();
  }

  // will not compile
  // void doStuff()throws MyException {
  // // insert code here
  // System.out.println(7 / 0);
  // }

  // works fine because it's runtime exception
  void doStuff() throws RuntimeException, ArithmeticException {
    // insert code here
    System.out.println(7 / 0);
  }
}

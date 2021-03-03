package com.marmoush.javasamples.java6.scjpbook.chp02;

class A {}

class B extends A {}

/*
 * In general, overloaded var-args methods are chosen last. Remember that arrays
 * are objects. Finally, an int can be boxed to an Integer and then "widened" to
 * an Object.
 */
public class ComingThru {
  static String s = "-";

  public static void main(String[] args) {
    A[] aa = new A[2];
    B[] ba = new B[2];
    sifter(aa);
    sifter(ba);
    sifter(7);
    System.out.println(s);
  }

  static void sifter(Object o) {
    s += "4";
  }

  static void sifter(B[] b1) {
    s += "3";
  }

  static void sifter(A[]... a2) {
    s += "1";
  }

  static void sifter(B[]... b1) {
    s += "2";
  }
}

package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.io.Serializable;
import java.text.NumberFormat;

public class SelfTest implements Serializable {
  public static void main(String[] args) {
    drill1();
    String s = "987.123456";
    double d = 987.1234559d;
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(5);
    System.out.println(nf.format(d) + " ");
    try {
      System.out.println(nf.parse(s));
    } catch (Exception e) {
      System.out.println("got exc");
    }
  }

  static void drill1() {
    String s = new String("hello");
    System.out.println(s.substring(0, 1));
  }

  static void question3() {}
}

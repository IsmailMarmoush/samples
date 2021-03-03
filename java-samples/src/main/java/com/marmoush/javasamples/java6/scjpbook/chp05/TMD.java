package com.marmoush.javasamples.java6.scjpbook.chp05;

public class TMD {
  public static void main(String[] args) {
    go();
    int j = 3;
    assert (j > 10) : "hello";
    int k = 0;
    System.out.println(7 / 0);
  }

  public static void go() {
    try {
      throw new Exception();
      // System.out.println("hello exception");
    } catch (Exception e) {
      // e.printStackTrace();
    } finally {
      System.out.println("hello finally");
    }
  }
}

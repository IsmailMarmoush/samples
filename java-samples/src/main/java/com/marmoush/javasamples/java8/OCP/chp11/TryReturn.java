package com.marmoush.javasamples.java8.OCP.chp11;

public class TryReturn {
  public static void main(String[] args) {
    m();
  }

  public static String m() {
    try {
      System.out.println("before return");
      return "hello";
    } finally {
      System.out.println("In finally");
    }
  }
}

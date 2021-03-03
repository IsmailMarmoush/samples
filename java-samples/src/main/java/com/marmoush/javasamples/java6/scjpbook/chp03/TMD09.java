package com.marmoush.javasamples.java6.scjpbook.chp03;

public class TMD09 {

  static String s = "";

  static void doStuff(Integer... i) {
    s += "3";
  }

  static void doStuff(Long L) {
    s += "4";
  }

  public static void main(String[] args) {
    int x = 4;
    Boolean y = true;
    short[] sa = {1, 2, 3};
    doStuff(x, y);
    doStuff(x);
    doStuff(sa, sa);
    System.out.println(s);
  }

  static void doStuff(Object... o) {
    s += "2";
  }

  static void doStuff(Object o) {
    s += "1";
  }
}

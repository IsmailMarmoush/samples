package com.marmoush.javasamples.java6.scjpbook.chp05;

public class SelfTest {
  public static void main(String[] args) {
    question10();
    // question11();
    System.out.println();
    question12();
    System.out.println();
    int k = 1;
    System.out.println(new SelfTest());
  }

  static void question10() {
    int[] ia = {1, 3, 5, 7, 9};
    for (int x : ia) {
      for (int j = 0; j < 3; j++) {
        // System.out.println();
        // System.out.println("J= "+j);
        if (x > 4 && x < 8)
          continue;
        System.out.print(" " + x);
        if (j == 1)
          break;
        continue;
      }
      continue;
    }
  }

  static void question12() {
    // int x = 2;
    label:
    for (int j = 0; j < 5; j++) {
      for (int k = 0; k < 3; k++) {
        System.out.print(" " + j);
        if (j == 3 && k == 1)
          break label;
        if (j == 0 || j == 2)
          break;
      }
    }
    // label;
  }

  static void question11() {
    String s = "";
    try {
      s += "1";
      throw new Exception();
    } catch (Exception e) {
      s += "2";
    } finally {
      s += "3";
      doStuff();
      s += "4";
    }
    System.out.println(s);
  }

  static void doStuff() {
    int x = 0;
    int y = 7 / x;
  }
}

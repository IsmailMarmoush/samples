package com.marmoush.javasamples.java6.scjpbook.chp03;

public class TMD08 {

  static int ouch = 7;

  public static void main(String[] args) {
    new TMD08().go(ouch);
    System.out.print(" " + ouch);
  }

  void go(int ouch) {
    ouch++;
    // compilation fails
    // for (int ouch = 3; ouch < 6; ouch++)
    // ;
    System.out.print(" " + ouch);
  }
}

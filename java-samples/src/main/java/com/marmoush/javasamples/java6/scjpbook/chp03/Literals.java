package com.marmoush.javasamples.java6.scjpbook.chp03;

public class Literals {
  public static void main(String[] args) {
    int oct = 077;
    System.out.println(oct); // prints 63
    System.out.println("hi " + oct); // prints 63

    int k = 30;
    double y = 20.3d;
    int octal = 07777;

    System.out.println(k * y);
    System.out.println(y * octal);
    System.out.println(k + y);
    System.out.println(y * y);
  }
}

package com.marmoush.javasamples.java6.scjpbook.chp03;

public class TMD02 {}

class Alien {
  String invade(short ships) {
    return "a few";
  }

  String invade(short... ships) {
    return "many";
  }
}

class Defender {
  public static void main(String[] args) {
    // 7 should be casted to short, compilation error
    // System.out.println(new Alien().invade(7));
    System.out.println(new Alien().invade((short) 7));
  }
}

package com.marmoush.javasamples.java8.OCP.ch02;

interface Climb {
  static void hello() {}

  boolean isTooHigh(int height, int limit);

  ;
}

public class Interfaces2 {}

class Climber {
  public static void main(String[] args) {
    check((h, l) -> true, 5); // x1
  }

  private static void check(Climb climb, int height) {
    if (climb.isTooHigh(height, 10)) { // x2
      System.out.println("too high");
    } else {
      System.out.println("ok");
    }
  }
}

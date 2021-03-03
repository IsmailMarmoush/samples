package com.marmoush.javasamples.java8.OCP.ch01;

enum Season3 {
  WINTER {
    public void printHours() {
      System.out.println("short hours");
    }
  },
  SUMMER {
    public void printHours() {
      System.out.println("long hours");
    }
  },
  SPRING,
  FALL;

  public void printHours() {
    System.out.println("default hours");
  }
}

public class Enums3 {
  public static void main(String[] args) {
    Season3.WINTER.printHours();
    Season3.FALL.printHours();
  }
}

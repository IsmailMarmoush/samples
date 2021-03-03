package com.marmoush.javasamples.java8.OCP.ch01;

enum Season2 {
  WINTER {
    public void printHours() {
      System.out.println("9am-3pm");
    }
  },
  SPRING {
    public void printHours() {
      System.out.println("9am-5pm");
    }
  },
  SUMMER {
    public void printHours() {
      System.out.println("9am-7pm");
    }
  },
  FALL2 {
    public void printHours() {
      System.out.println("9am-5pm");
    }
  };

  public abstract void printHours();
}

public class Enums2 {
  public static void main(String[] args) {

  }
}

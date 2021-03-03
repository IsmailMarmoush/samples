package com.marmoush.javasamples.java8.OCP.ch02;

interface MyInterface {
  public static int hi = 22;
}

public class Interfaces {
  public static void main(String[] args) {
    MyInterface m = new MyInterface() {};
    System.out.println(m.hi);
  }
}

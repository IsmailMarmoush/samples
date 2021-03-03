package com.marmoush.javasamples.java7;

public class SwitchSample {
  public static void main(String[] args) {
    String s = "hi";
    switch (s) {
      case "hello":
        System.out.println("hello");
        break;
      case "hi":
        System.out.println("hi");
        break;
      default:
        break;
    }
  }
}

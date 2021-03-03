package com.marmoush.javasamples.java8.OCP.ch01;

import java.util.Set;
import java.util.TreeSet;

enum Season {
  WINTER("Low", 3),
  SPRING("Medium", 2),
  SUMMER("High", 4),
  FALL("Medium", 1);
  private String expectedVisitors;
  private int months;

  private Season(String expectedVisitors, int months) {
    this.expectedVisitors = expectedVisitors;
    this.months = months;
  }

  public void printExpectedVisitors() {
    System.out.println(expectedVisitors + ":" + months);
  }
}

public class Enums {
  public static void main(String[] args) {
    Set<String> names = new TreeSet<String>();
    names.add("111");
    names.add("222");
    names.add("111");
    names.add("333");
    System.out.println(names);
    for (String name : names) {
      switch (name) {
        case "111":
          System.out.print("111 ");
          //          break;
        default:
          System.out.print("333 ");
          //          break;
        case "222":
          System.out.print("222 ");
      }
    }
  }
}


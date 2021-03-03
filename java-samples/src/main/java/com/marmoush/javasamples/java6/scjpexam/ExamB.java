package com.marmoush.javasamples.java6.scjpexam;

import java.util.ArrayList;
import java.util.List;

public class ExamB {
  public static void main(String[] args) {
    Integer i = 3;
    Float f = new Float(3.14f);
    if (f > 3) {
      System.out.println("yeah");
    } else {
      System.out.println("oh");
    }
    ArrayList arr = new ArrayList();
    foo(arr);
  }

  static void foo(List<String> list) {
    list.add(new String("helloman"));
    System.out.println(list.get(0));
  }
}

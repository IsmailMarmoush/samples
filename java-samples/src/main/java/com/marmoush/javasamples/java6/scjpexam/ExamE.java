package com.marmoush.javasamples.java6.scjpexam;

public class ExamE {
  String title;

  public ExamE() {
    title += "helo";
  }

  public ExamE(int x) {
    System.out.println(x);
    // ExamE(); // undefined method : you can see it must be first line
  }
}

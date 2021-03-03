package com.marmoush.javasamples.java6.scjpexam;

public class ExamD {
  public static void main(String[] args) {
    int x = 6;
    ExamD d = new ExamD();
    d.doStuff(x);
    System.out.println("main x=" + x);
  }

  void doStuff(int x) {
    System.out.println("dostuff x=" + x++);
  }
}

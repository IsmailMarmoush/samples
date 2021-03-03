package com.marmoush.javasamples.java6.scjpexam;

import java.util.HashSet;

public class ExamChashing {
  public static void main(String[] args) {
    WrappedString ws1 = new WrappedString("hello");
    WrappedString ws2 = new WrappedString("hello");
    String s1 = "hello";
    HashSet<Object> hs = new HashSet<Object>();
    hs.add(ws1);
    hs.add(ws2);
    hs.add(s1);
    hs.add("hello");

    System.out.println(hs.size());
  }
}

class WrappedString {
  private String s;

  public WrappedString(String s) {
    this.s = s;
  }
}

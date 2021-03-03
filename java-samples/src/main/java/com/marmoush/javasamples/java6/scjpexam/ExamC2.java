package com.marmoush.javasamples.java6.scjpexam;

class c2 {
  public c3 cc3;

  public String getvalue() {
    return cc3.getvalue();
  }
}

class c3 {
  public String s;

  public String getvalue() {
    s = "value";
    return s;
  }
}

public class ExamC2 {
  public c2 t;

  public static void main(String[] args) {
    ExamC2 ex = new ExamC2();
    ex.getvalue();
  }

  public String getvalue() {
    return t.getvalue();
  }
}

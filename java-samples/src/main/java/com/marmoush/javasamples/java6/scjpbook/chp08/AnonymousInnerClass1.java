package com.marmoush.javasamples.java6.scjpbook.chp08;

public class AnonymousInnerClass1 {
  public static void main(String[] args) {
    Food1 f = new Food1();
  }
}

class Food1 {
  Popcorn p = new Popcorn() {
    @Override
    public void pop() {
      System.out.println("anonymous popcorn");
      sizzle(); // ok
    }

    public void sizzle() {
      System.out.println("anonymous sizzling popcorn");
    }
  }; // watch for semicolon

  public Food1() {
    p.pop();
    // p.sizzle();// not ok
  }
}

class Popcorn {
  public void pop() {
    System.out.println("popcorn");
  }
}

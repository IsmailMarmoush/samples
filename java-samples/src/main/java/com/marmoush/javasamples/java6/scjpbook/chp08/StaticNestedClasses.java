package com.marmoush.javasamples.java6.scjpbook.chp08;

/*
 * Just as a static method does not have access to the instance variables and
 * nonstatic methods of the class, a static nested class does not have access to
 * the instance variables and nonstatic methods of the outer class. Look for
 * static nested classes with code that behaves like a nonstatic (regular inner)
 * class
 */
class BigOuter {
  static class Nest {
    void go() {
      System.out.println("hi");
    }
  }
}

class Broom {
  public static void main(String[] args) {
    BigOuter.Nest n = new BigOuter.Nest(); // both class names
    n.go();
    B2 b2 = new B2(); // access the enclosed class
    b2.goB2();
  }

  static class B2 {
    int k;
    Integer i = null;

    void goB2() {
      System.out.println("hi 2");
    }
  }
}

public class StaticNestedClasses {
  public static void main(String[] args) {
    BigOuter.Nest n = new BigOuter.Nest();
    n.go();
    Broom.B2 b2 = new Broom.B2();
    b2.goB2();
  }
}

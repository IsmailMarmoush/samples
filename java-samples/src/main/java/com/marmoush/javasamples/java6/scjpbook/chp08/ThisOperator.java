package com.marmoush.javasamples.java6.scjpbook.chp08;

class MyOuter2 {
  private int x = 7;

  public void makeInner() {
    MyInner2 in = new MyInner2(); // make an inner instance
    in.seeOuter2();
  }

  class MyInner2 {
    public void seeOuter2() {
      System.out.println("Outer x is " + x);
      System.out.println("Inner class ref is " + this);
      System.out.println("Outer class ref is " + MyOuter2.this);
    }
  }

  // Member Modifiers Applied to Inner Classes A regular inner class is a
  // member of the outer class just as instance variables and methods are, so
  // the following modifiers can be applied to an inner class:
  // n final
  // n abstract
  // n public
  // n private
  // n protected
  // n static�but static turns it into a static nested class not an inner
  // class
  // n strictfp
}

public class ThisOperator {
  public static void main(String[] args) {
    MyOuter2.MyInner2 inner = new MyOuter2().new MyInner2();
    inner.seeOuter2();
  }
}

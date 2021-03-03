package com.marmoush.javasamples.java6.scjpbook.chp08;

public class InnerClasses {
  private static int k = 3;

  public static void main(String[] args) {
    /*
     * "Regular" Inner Class regular here to represent inner classes that
     * are not (* Static * Method-local * Anonymous)
     */
    MyOuter1 mo = new MyOuter1(); // gotta get an instance!
    MyOuter1.MyInner1 inner = mo.new MyInner1();
    inner.seeOuter1();

    MyOuter1.MyInner1 inner2 = new MyOuter1().new MyInner1();
    inner2.seeOuter1();

    // Summary:
    /*
     * To instantiate it, you must use a reference to the outer class: new
     * MyOuter().new MyInner(); or outerObjRef.new MyInner();
     */

    /*
     * The keyword this can be used only from within instance code. In other
     * words, not within static code.
     */

  }
}

class MyOuter1 {
  private int x = 7;

  public void makeInner1() {
    MyInner1 in = new MyInner1(); // make an inner instance
    in.seeOuter1();
  }

  class MyInner1 {
    public void seeOuter1() {
      System.out.println("Outer x is " + x);
    }
  }
}

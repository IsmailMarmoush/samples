package com.marmoush.javasamples.java6.scjpbook.chp07.part1;

public class EqualsFunc {
  public static void main(String[] args) {
    // Take care of the next trick
    // class Foo { boolean equals(Object o) { } }
    /*
     * The equals() method in class Boo changes the argument from Object to
     * Boo, so it becomes an overloaded method and won�t be called unless
     * it�s from your own code that knows about this new, different method
     * that happens to also be named equals().
     *
     * class Boo { public boolean equals(Boo b) { } }
     */

    /*
     * The equals() Contract Pulled straight from the Java docs,
     *
     * It is reflexive. For any reference value x, x.equals(x) should return
     * true.
     *
     * It is symmetric. For any reference values x and y, x.equals(y) should
     * return true if and only if y.equals(x) returns true.
     *
     * It is transitive. For any reference values x, y, and z, if
     * x.equals(y) returns true and y.equals(z) returns true, then
     * x.equals(z) must return true.
     *
     * It is consistent.For any reference values x and y, multiple
     * invocations of x.equals(y) consistently return true or consistently
     * return false, provided no information used in equals comparisons on
     * the object is modified.
     *
     * For any non-null reference value x, x.equals(null) should return
     * false.
     */

    /*
     * So to be truly safe, your rule of thumb should be, if you override
     * equals(), override hashCode() as well. So let's switch over to
     * hashCode() and see how that method ties in to equals().
     */

  }
}

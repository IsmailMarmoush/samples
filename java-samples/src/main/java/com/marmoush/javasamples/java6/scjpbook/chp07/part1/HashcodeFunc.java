package com.marmoush.javasamples.java6.scjpbook.chp07.part1;

public class HashcodeFunc {
  public static void main(String[] args) {
    /*
     * The hashCode()contract:
     *
     * Whenever it is invoked on the same object more than once during an
     * execution of a Java application, the hashCode() method must
     * consistently return the same integer, provided no information used in
     * equals() comparisons on the object is modified. This integer need not
     * remain consistent from one execution of an application to another
     * execution of the same application.
     *
     * x.equals(y) == true Required: x.hashCode() == y.hashCode()
     *
     *
     *
     * If two objects are equal according to the equals(Object) method, then
     * calling the hashCode() method on each of the two objects must produce
     * the same integer result.
     *
     * x.hashCode() == y.hashCode() Not Required but allowed: x.equals(y) ==
     * true
     *
     * It is NOT required that if two objects are unequal according to the
     * equals(java.lang.Object) method, then calling the hashCode() method
     * on each of the two objects must produce distinct integer results.
     * However, the programmer should be aware that producing distinct
     * integer results for unequal objects may improve the performance of
     * hashtables.
     *
     * x.hashCode() != y.hashCode() Required: x.equals(y) == false
     */

    /*
     * Bottom line: transient variables can really mess with your equals()
     * and hashCode() implementations. Keep variables non-transient or, if
     * they must be marked transient, don't use them to determine hashcodes
     * or equality.
     */

  }
}

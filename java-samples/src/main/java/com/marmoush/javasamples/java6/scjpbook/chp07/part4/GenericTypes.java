package com.marmoush.javasamples.java6.scjpbook.chp07.part4;

import java.util.ArrayList;
import java.util.List;

public class GenericTypes {
  public static void main(String[] args) {
    /*
     * before Java 5 there was no syntax for declaring a type safe
     * collection. To make an ArrayList of Strings, you said,
     */
    // ArrayList myList = new ArrayList();
    // or, the polymorphic equivalent
    // List myList = new ArrayList();

    /*
     * think of collections as the overwhelming reason and motivation for
     * adding generics to the language.
     */

    /*
     * In most questions on the exam, you care only about compiles vs.
     * compilation fails�compiler warnings don�t matter for most of the
     * exam. But when you are using generics, and mixing both typed and
     * untyped code, warnings matter.
     */

    List<Integer> myList = new ArrayList<Integer>();
    myList.add(4);
    myList.add(6);
    Inserter in = new Inserter();
    in.insert(myList); // pass List<Integer> to legacy code

    // group 2
    GenericTypes g = new GenericTypes();
    g.unboxing();
  }

  public void unboxing() {
    /*
     * When using legacy (non-type safe) collections�watch out for unboxing
     * problems! If you declare a non-generic collection, the get() method
     * ALWAYS returns a reference of type java.lang.Object. Remember that
     * unboxing can�t convert a plain old Object to a primitive, even if
     * that Object reference refers to an Integer (or some other wrapped
     * primitive) on the heap. Unboxing converts only from a wrapper class
     * reference (like an Integer or a Long) to a primitive.
     */
    List test = new ArrayList();
    test.add(43);
    int x = (Integer) test.get(0); // you must cast !!
    List<Integer> test2 = new ArrayList<Integer>();
    test2.add(343);
    int x2 = test2.get(0); // cast not necessary

    /*
     * Watch out for missing casts associated with pre-Java 5, non-generic
     * collections.
     */
  }
}

class Inserter {
  // Legacy code
  // method with a non-generic List argument
  void insert(List list) {
    list.add(new Integer(42)); // adds to the incoming list
  }
}

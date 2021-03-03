package com.marmoush.javasamples.java6.scjpbook.chp07.part4;

import java.util.ArrayList;
import java.util.List;

public class GenericPolymorphism {
  public static void main(String[] args) {}

  public void arraysArePolymorphic() {
    // The next is OK !
    // Parent[] myArray = new Child[3]; // yes
    // Object[] myArray = new JButton[3]; // yes
  }

  public void polymorphicGeniricsBaseOnly() {

    /*
     * In other words, we were able to assign an ArrayList to a List
     * reference, because List is a supertype of ArrayList. Nothing special
     * ther polymorphism applies to the "base" type of the collection:
     */
    List<Integer> myList = new ArrayList<Integer>();
    /*
     * There's a very simple rule here�the type of the variable declaration
     * must match the type you pass to the actual object type.
     */
    // List<Object> myList = new ArrayList<JButton>(); // NO!
  }
}

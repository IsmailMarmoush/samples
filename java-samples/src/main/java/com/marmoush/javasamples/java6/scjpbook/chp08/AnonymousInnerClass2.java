package com.marmoush.javasamples.java6.scjpbook.chp08;

interface Cookable {
  public void cook();
}

public class AnonymousInnerClass2 {
  public static void main(String[] args) {
    Food2 f = new Food2();
  }
}

class Food2 {
  // Important Note
  /*
   * Declare a reference variable of type Cookable that, obviously, will refer
   * to an object from a class that implements the Cookable interface. But, oh
   * yes, we don't yet have a class that implements Cookable, so we're going
   * to make one right here, right now. We don't need a name for the class,
   * but it will be a class that implements Cookable, and this curly brace
   * starts the definition of the new implementing class.
   */ Cookable c = new Cookable() {
    @Override
    public void cook() {
      System.out.println("anonymous cookable implementer");
    }
  };

  public Food2() {
    c.cook();
  }
  /*
   * If the anonymous inner class is a subclass of a class type, it
   * automatically becomes an implementer of any interfaces implemented by the
   * superclass.
   */
}

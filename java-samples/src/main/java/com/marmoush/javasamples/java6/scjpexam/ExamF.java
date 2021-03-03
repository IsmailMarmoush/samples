package com.marmoush.javasamples.java6.scjpexam;

class Animal2 {
  public static final String s = "animal";

  public void bla() {
    System.out.println("animal");
  }

  public void ex() {}
}

class Dog2 extends Animal2 {
  public static final String s = "dog";

  @Override
  public void bla() {
    System.out.println("dog");
  }

  // public void ex() throws Exception {

  // }
}

public class ExamF {
  public static void main(String[] args) {

    Animal2 an = new Dog2();
    an.bla(); // dog - Explicit casting, polymorphism
    // Dog2 dog = (Dog2) new Animal2(); // cast exception
    // dog.bla();
    assert (!(1 > 0)) : an = null;
    Dog2 d2 = new Dog2();
    System.out.println(Animal2.s);
    try {
      d2.ex();
    } catch (Exception e) {

      e.printStackTrace();
    }
    int k = 0;
    z:
    k += k; // warning k is never referenced
    for (int i = 0; i < args.length; i++) {
      // break k; missing label k
    }
  }
}

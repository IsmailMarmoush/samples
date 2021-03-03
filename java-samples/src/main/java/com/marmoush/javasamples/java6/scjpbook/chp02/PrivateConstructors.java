package com.marmoush.javasamples.java6.scjpbook.chp02;

public class PrivateConstructors {
  public static void main(String[] args) {
    // it's like if the class doesn't even exist
    // new Parent();

    /*
     * but still you can create a variable of type parent but since you
     * can't extend this class I don't know how we can use that variable
     */
    Parent c;
  }
}

class Parent {
  private Parent() {
    System.out.println("parent");
  }
}

// Can't extend a class with private constructor
// class Child extends Parent {
//
// }
class Child {}

// VIP
/*
 * This kind of notation is usually used in utility classes or singletons, where
 * you don't want the user to create himself an instance of your class, either
 * by extending it and instanciating the subclass, or by simply calling a
 * constructor of your class.
 *
 * When you have a class with only private constructors, you can also change the
 * class to final because it can't be extended at all.
 *
 * Another solution would be having a method in test which create instances of
 * test and delegate every method call from One to a test instance. This way you
 * don't have to extend test.
 */

class Test {
  private Test() {
    System.out.println("test");
  }

  public static Test getInstance() {
    return new Test();
  }

  public void methodA() {
    // Some kind of implementation
  }
}

class One {
  private final Test test;

  One() {
    System.out.println("One");
    test = Test.getInstance();
  }

  public static void main(String args[]) {
    new One();
  }

  public void methodA() {
    test.methodA();
  }
}

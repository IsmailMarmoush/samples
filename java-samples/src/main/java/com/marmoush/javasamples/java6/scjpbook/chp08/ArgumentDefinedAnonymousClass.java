package com.marmoush.javasamples.java6.scjpbook.chp08;

interface Foo {
  void foof();
}

public class ArgumentDefinedAnonymousClass {}

class Bar {
  void doStuff(Foo f) {}
}

class MyWonderfulClass {
  void go() {
    Bar b = new Bar();
    b.doStuff(new Foo() {
      @Override
      public void foof() {
        System.out.println("foofy");
      }
    });
    /*
     * If they're argument local, they end like this: });
     *
     * but if they're just plain-old anonymous classes, then they end like
     * this: };
     */
  }
}

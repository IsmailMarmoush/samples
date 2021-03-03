package com.marmoush.javasamples.java6.scjpbook.chp02;

class Mammal {
  String name = "furry ";

  String makeNoise() {
    return "generic noise";
  }
}

class Zebra extends Mammal {
  String name = "stripes ";

  String makeNoise() {
    return "bray";
  }
}

public class ZooKeeper {
  public static void main(String[] args) {
    new ZooKeeper().go();
  }

  void go() {
    Mammal m = new Zebra();
    // Polymorphism is only for instance methods.!!!!!!!!!!!!!!
    System.out.println(m.name + m.makeNoise());
  }
}

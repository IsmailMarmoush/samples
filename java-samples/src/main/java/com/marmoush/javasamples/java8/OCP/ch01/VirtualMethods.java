package com.marmoush.javasamples.java8.OCP.ch01;

public class VirtualMethods {
  public static void main(String... args) {
    Animal animal = new Lion();
    animal.printName();
  }
}

abstract class Animal {
  String name = "???";

  public void printName() {
    System.out.println(name);
  }
}

class Lion extends Animal {
  String name = "Leo";
  // if following method was uncommented it would have been leo
  //  public void printName(){
  //    System.out.println(name);
  //  }
}

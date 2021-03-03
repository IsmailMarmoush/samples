package com.marmoush.javasamples.java6.scjpexam;

class Animal {}

class Dog extends Animal {}

public class ExamBClassCast {
  public static void main(String[] args) {
    Animal b = new Dog(); // ok
    Dog a = (Dog) new Animal(); // ok

    Animal b2 = new Animal();
    // Not ok class cast exception because of object is animal
    Dog d = (Dog) b2;
  }
}

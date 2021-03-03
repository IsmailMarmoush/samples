package com.marmoush.javasamples.java8.OCP.ch03;

import java.util.ArrayList;
import java.util.List;

public class LowerBounds {
  public static void main(String[] args) {
    List<Animal> m = new ArrayList<>();
    m.add(new Animal());
    m.add(new Mammal());
    hello(m);

    List<Mammal> x = new ArrayList<>();
    // x.add(new Animal()); // Doesn't compile because it's ArrayList<Mammal> and this also won't
    // compile because of next

    // List<Mammal> y = new ArrayList<Dog>(); // Doesn't compile
    // List<Mammal> xx = new ArrayList<Animal>(); // Doesn't compile

    List<? super Mammal> z = new ArrayList<Mammal>();
    z.add(new Dog());
    z.add(new Mammal());
    // z.add(new Animal()); // Doesn't compile, just like the following, depends on the reference

    Mammal an = new Mammal();
    an = new Dog();
    //    an=new Animal();

    List<? super Mammal> y = new ArrayList<Animal>();
    y.add(new Dog());
    y.add(new Mammal());
    // y.add(new Animal());  // Doesn't compile

  }

  public static String hello(List<? super Mammal> x) {
    x.add(new Mammal());
    // x.add(new Animal()); // Doesn't compile, check line 20
    // Even if you might pass ArrayList<Animal>() since it allows super, you still can't add it
    // (stupid a bit)
    return "";
  }
}

class Animal {}

class Mammal extends Animal {}

class Dog extends Mammal {}

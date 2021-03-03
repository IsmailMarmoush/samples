package com.marmoush.javasamples.java6.scjpbook.chp07.part4;

import java.util.ArrayList;

abstract class Animal {
  public abstract void checkup();
}

class AnimalDoctor {
  // method takes an array of any animal subtype
  public void checkAnimals(Animal[] animals) {
    for (Animal a : animals) {
      a.checkup();
    }
  }
}

class AnimalDoctorGeneric { // change the argument from Animal[] to
  // ArrayList<Animal>
  public void checkAnimals(ArrayList<Animal> animals) {
    for (Animal a : animals) {
      a.checkup();
    }
  }
}

class Bird extends Animal {
  @Override
  public void checkup() { // implement Bird-specific code
    System.out.println("Bird checkup");
  }
}

class Cat extends Animal {
  @Override
  public void checkup() { // implement Cat-specific code
    System.out.println("Cat checkup");
  }
}

class Dog extends Animal {
  @Override
  public void checkup() { // implement Dog-specific code
    System.out.println("Dog checkup");
  }
}

public class Zoo {}

package com.marmoush.javasamples.java6.scjpbook.chp07.part4;

import java.util.ArrayList;
import java.util.List;

public class CollectionsAndGenericMethods {
  public static void main(String[] args) {}

  public void testArraysElemDangerous() {
    List<Dog> animals = new ArrayList<Dog>();
    animals.add(new Dog());
    animals.add(new Dog());
    // addAnimal(animals); // THIS is where it breaks!
  }

  public void testArraysElemNotDangerous() {
    List<Animal> animals = new ArrayList<Animal>();
    animals.add(new Dog());
    animals.add(new Dog());
    addAnimal(animals); // OK, since animals matches
    // the method arg
  }

  private void addAnimal(List<Animal> animals) {
    animals.add(new Dog()); // this is always legal,
    // since Dog can
    // be assigned to an Animal
    // reference
  }

  // works BUT !
  public void testGenCollElemPoly() {
    List<Animal> animals = new ArrayList<Animal>();
    animals.add(new Cat()); // OK
    animals.add(new Dog()); // OK

    // but
    /*
     * why is this bad? And why is it bad for ArrayList but not arrays? Why
     * can't you pass an ArrayList<Dog> to an argument of ArrayList<Animal>?
     * Actually, the problem IS just as dangerous whether you're using
     * arrays or a generic collection.
     */
  }

  // Doesn't work
  public void testGenCollPoly() {
    // make ArrayLists instead of arrays for Dog, Cat, Bird
    List<Dog> dogs = new ArrayList<Dog>();
    dogs.add(new Dog());
    dogs.add(new Dog());
    List<Cat> cats = new ArrayList<Cat>();
    cats.add(new Cat());
    cats.add(new Cat());
    List<Bird> birds = new ArrayList<Bird>();
    birds.add(new Bird());

    /** ***************** Here comes the errors ******* */
    // this code is the same as the Array version
    AnimalDoctorGeneric doc = new AnimalDoctorGeneric();
    // this worked when we used arrays instead of ArrayLists
    // doc.checkAnimals(dogs); // send a List<Dog>
    // doc.checkAnimals(cats); // send a List<Cat>
    // doc.checkAnimals(birds); // send a List<Bird>
  }
}

package com.marmoush.javasamples.java6.scjpbook.chp07.part4;

public class ArraysAndGenericMethods {
  ArraysAndGenericMethods g = new ArraysAndGenericMethods();

  public static void main(String[] args) {}

  // works but
  public void testArraysElemPoly() {
    Animal[] animals = new Animal[3];
    animals[0] = new Cat();
    animals[1] = new Dog();
    // but Dangerous ArrayStoreException
    g.testArraysElemNotDangerous();
    g.testArraysElemDangerous();
  }

  public void testArraysElemNotDangerous() {
    Dog[] dogs = {new Dog(), new Dog()};
    addAnimal2Array(dogs); // no problem, send the Dog[] to the method
  }

  public void testArraysElemDangerous() {
    Cat[] cats = {new Cat(), new Cat()};
    addAnimal2Array(cats); // no problem, send the Cat[] to the method
  }

  public void addAnimal2Array(Animal[] animals) {
    animals[0] = new Dog(); // Eeek! We just put a Dog
    // in a Cat array!
  }

  // works
  public void testArraysPolymorphism() {
    // test it
    Dog[] dogs = {new Dog(), new Dog()};
    Cat[] cats = {new Cat(), new Cat(), new Cat()};
    Bird[] birds = {new Bird()};
    /** ***************** Here NO Errors ******* */
    AnimalDoctor doc = new AnimalDoctor();
    doc.checkAnimals(dogs); // pass the Dog[]
    doc.checkAnimals(cats); // pass the Cat[]
    doc.checkAnimals(birds); // pass the Bird[]
  }
}

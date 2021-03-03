package com.marmoush.javasamples.java6.scjpbook.chp07.part4;

import java.util.ArrayList;
import java.util.List;

/*
 * And you can use a form of wildcard notation in a class definition, to specify
 * a range (called "bounds") for the type that can be used for the type
 * parameter:
 */
class AnimalHolder<T extends Animal> { // use "T" instead
  // of "?"
  T animal;

  public static void main(String[] args) {
    AnimalHolder<Dog> dogHolder = new AnimalHolder<Dog>(); // OK
    // AnimalHolder<Integer> x = new AnimalHolder<Integer>(); // NO!
  }
}

public class GenericDeclarations<T> {
  // parameter
  private List<T> rentalPool; // Use the class type for the
  // List type
  private int maxNum;

  public GenericDeclarations(int maxNum, List<T> rentalPool) {
    /** *************************************************** */
    // List of the class type
    this.maxNum = maxNum;
    this.rentalPool = rentalPool;
  }

  public static void main(String[] args) {
    // make some Dogs for the pool
    Dog c1 = new Dog();
    Dog c2 = new Dog();
    List<Dog> DogList = new ArrayList<Dog>();
    DogList.add(c1);
    DogList.add(c2);
    GenericDeclarations<Dog> DogRental = new GenericDeclarations<Dog>(2, DogList);
    // now get a Dog out, and it won't need a cast
    Dog DogToRent = DogRental.getRental();
    DogRental.returnRental(DogToRent);
    // can we stick something else in the original DogList?
    // DogList.add(new Cat("Fluffy")); // nope we can't
  }

  public T getRental() { // we rent out a T
    // blocks until there's something available
    return rentalPool.get(0);
  }

  public void returnRental(T returnedThing) { // and the renter
    // returns a T
    rentalPool.add(returnedThing);
  }

  /*
   * The strangest thing about generic methods is that you must declare the
   * type variable BEFORE the return type of the method:
   */
  public <T> void makeArrayList(T t) {}

  /*
   * You're also free to put boundaries on the type you declare, for example,
   * if you want to restrict the makeArrayList() method to only Number or its
   * subtypes (Integer, Float, and so on) you would say
   */
  public <T extends Number> void makeArrayList(T t) {}
}

class UseTwo<T, X> {
  T one;
  X two;

  UseTwo(T one, X two) {
    this.one = one;
    this.two = two;
  }

  // test it by creating it with <String, Integer>
  public static void main(String[] args) {
    UseTwo<String, Integer> twos = new UseTwo<String, Integer>("foo", 42);
    String theT = twos.getT(); // returns a String
    int theX = twos.getX(); // returns Integer, unboxes to int
  }

  T getT() {
    return one;
  }

  X getX() {
    return two;
  }
}

/*
 * If you REALLY want to get ridiculous (or fired), you can declare a class with
 * a name that is the same as the type parameter placeholder:
 */
class X {
  public <X> X(X x) {}
}
/*
 * Yes, this works. The X that is the constructor name has no relationship to
 * the <X> type declaration, which has no relationship to the constructor
 * argument identifier, which is also, of course, X. The compiler is able to
 * parse this and treat each of the different uses of X independently. So there
 * is no naming conflict between class names, type parameter placeholders, and
 * variable identifiers.
 */

/*
 * One of the most common mistakes programmers make when creating generic
 * classes or methods is to use a <?> in the wildcard syntax rather than a type
 * variable <T>, <E>, and so on. This code might look right, but isn�t:
 */

/**
 * class NumberHolder<? extends Number> { } // invalid type parameter *  class NumberHolder<?> { ? aNum; } // NO! *
 * class NumberHolder<?> { ? aNum; } // NO! * class NumberHolder<?> { ? aNum; } // NO! *
 */

/*
 * While the question mark works when declaring a reference for a variable, it
 * does NOT work for generic class and method declarations. This code is not
 * legal:
 */
/** class NumberHolder<?> { ? aNum; } // NO! * */

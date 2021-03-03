package com.marmoush.javasamples.java6.scjpbook.chp07.part4;

import java.util.ArrayList;
import java.util.List;

public class WildCards {
  public WildCards() {

    /** *************** POLYMORPHISM WHEN CALLING ************* */
    /*
     * The Functions have different names because of Method addAnimal(List<?
     * super Dog>) has the same erasure addAnimal(List<E>) as another method
     * in type WildCards
     *
     * Overloading would take away your polymorphic flexibility
     */
    /*
     * the keyword extends in the context of a wildcard represents BOTH
     * subclasses and interface implementations. There is no <? implements
     * Serializable> syntax. If you want to declare a method that takes
     * anything that is of a type that implements Serializable, you'd still
     * use extends like this:
     *
     * void foo(List<? extends Serializable> list) // odd, but correct // to
     * use "extends"
     */

    addAnimalExtend(new ArrayList<Dog>());

    // not applicable for the arguments (List<Dog>)
    // addAnimalObj(new List<Dog>());
    addAnimalObj(new ArrayList<Object>());

    // This works fine <? super>
    addAnimalSuper(new ArrayList<Animal>());
    addAnimalSuper(new ArrayList<Dog>());

    // works with what ever but doesn't Add
    addAnimalWildCardOnly(new ArrayList<Object>());
    addAnimalWildCardOnly(new ArrayList<Integer>());
    addAnimalWildCardOnly(new ArrayList<Dog>());
  }

  private void addAnimalExtend(List<? extends Animal> animals) {
    /*
     * Compile Error because if the list was animal then you can add a Dog
     * or a Cat but because of "extends" so it can be
     * "extends Animal = Cat(passed)" so how come we can add a Dog now ? and
     * this is why
     */

    // animals.add(new Dog());
  }

  private void addAnimalObj(List<Object> animals) {
    /*
     * List<Object> is completely different from List<?>. List<Object> means
     * that the method can take ONLY a List<Object>. Not a List<Dog>, or a
     * List<Cat>. It does, however, mean that you can add to the list, since
     * the compiler has already made certain that you're passing only a
     * valid List<Object> into the method.
     */

    animals.add(new Dog());
  }

  private void addAnimalSuper(List<? super Dog> animals) {
    animals.add(new Dog());
    // but in super it's ok
  }

  private void addAnimalWildCardOnly(List<?> animals) {

    /*
     * you just can't add anything
     */
    // but can use it with anything
    // animals.add( new Dog());
  }

  public static void main(String[] args) {
    WildCards wc = new WildCards();
  }
}

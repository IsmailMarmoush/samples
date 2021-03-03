package com.marmoush.scalasamples.concepts

object Linearization {

  trait Furry extends Animal

  trait HasLegs extends Animal

  trait FourLegged extends HasLegs

  class Animal

  class Cat extends Animal with Furry with FourLegged
  // Animal, AnyRef, Any
  // Furry, Animal, AnyRef, Any
  // FourLegged, HasLegs, Animal, AnyRef, Any
  // HasLegs, Animal, AnyRef, Any
  // Cat, FourLegged, HasLegs, Furry, Animal, AnyRef, Any

}

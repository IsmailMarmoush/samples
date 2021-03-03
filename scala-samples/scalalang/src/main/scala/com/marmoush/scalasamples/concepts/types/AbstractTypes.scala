package com.marmoush.scalasamples.concepts.types

object AbstractTypes {

  abstract class Animal {
    type SuitableFood <: Food

    // It's OK to override a ‘def’ with a ‘val’, but you cannot override a ‘val’ with a ‘def’.
    def eat(food: SuitableFood)
  }

  class Food

  class Grass extends Food

  class Cow extends Animal {
    type SuitableFood = Grass

    override def eat(food: Grass) {}
  }

}

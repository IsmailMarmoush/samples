package com.marmoush.scalasamples.concepts

object Linearization2 extends App {
  new Alive() {}
  println()
  new Animal
  println()
  new Mammal // alive-animal-canEat-mammal
  println()
  new Dog // alive-animal-canEat-mammal-canWalk-canEat-canJump-dog
}

trait Alive {
  print("alive-")
}

class Animal extends Alive {
  print("Animal-")
}

trait CanWalk extends Animal {
  print("CanWalk-")
}

trait CanEat extends Animal {
  print("CanEat-")
}

trait CanJump extends Animal {
  print("CanJump-")
}

class Mammal extends CanEat {
  print("Mammal-")
}

class Dog extends Mammal with CanWalk with CanEat with CanJump {
  print("Dog-")
}

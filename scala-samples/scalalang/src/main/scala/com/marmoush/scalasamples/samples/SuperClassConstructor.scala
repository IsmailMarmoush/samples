package com.marmoush.scalasamples.samples

object SuperClassConstructor {

  // https://www.safaribooksonline.com/library/view/scala-cookbook/9781449340292/ch04s12.html
  // (1) primary constructor
  class Animal(var name: String, var age: Int) {
    // (2) auxiliary constructor
    def this(name: String) {
      this(name, 0)
    }

    override def toString = s"$name is $age years old"
  }

  // calls the Animal one-arg constructor
  class Dog(name: String) extends Animal(name) {
    println("Dog constructor called")
  }

  /** ****************************************/
  class ArrayElement(x: Array[String]) {
    def width = x.length

    def height = 1
  }

  class LineElement(s: String) extends ArrayElement(Array(s)) {
    override def width = s.length

    override def height = 1
  }

}

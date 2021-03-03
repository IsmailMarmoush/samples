package com.marmoush.scalasamples.concepts.TypeClasses

object TypeClasses {

  case class Person(name: String) {}

  trait Serializable[T] {
    def ser(t: T): String
  }

  def serialize[T](t: T, s: Serializable[T]): String = s.ser(t)

  object PersonIsSerializable extends Serializable[Person] {
    override def ser(t: Person): String = s"Name is: ${t.name}"
  }

  def main(args: Array[String]): Unit = {

    println(serialize(Person("bob"), PersonIsSerializable))
  }
}

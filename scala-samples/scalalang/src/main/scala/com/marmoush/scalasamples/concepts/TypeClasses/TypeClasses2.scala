package com.marmoush.scalasamples.concepts.TypeClasses

object TypeClasses {

  case class Person(name: String) {}

  trait Serializable[T] {
    def ser(t: T): String
  }

  def serialize[T](t: T)(implicit s: Serializable[T]): String = s.ser(t)

  implicit object PersonIsSerializable extends Serializable[Person] {
    override def ser(t: Person): String = s"Name is: ${t.name}"
  }

  implicit def listIsSerializable[T: Serializable](implicit ev: Serializable[T]) =
    new Serializable[List[T]] {
      override def ser(t: List[T]): String = t.map(ev.ser(_)).mkString("List(", ",", ")")
    }

  def main(args: Array[String]): Unit = {

    println(serialize(Person("bob")))
    println(serialize(List(Person("bob"), Person("Sara")))) // TODO why this is not working ?
  }
}

package com.marmoush.scalasamples.underscore_advancedscala

trait Printable[T] {
  def format(d: T): String
}

object PrintableInstances {
  implicit val printableInt = new Printable[Int] {
    def format(d: Int) = d.toString
  }
  implicit val printableString = new Printable[String] {
    def format(d: String) = d.toString
  }
}

// Interface objects
object Printable {
  def format[A](value: A)(implicit w: Printable[A]): String = w.format(value)
  def print[A](value: A)(implicit w: Printable[A]): Unit    = println(w)
}

// Interface syntax
object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit w: Printable[A]): String = w.format(value)
    def print(implicit w: Printable[A]): Unit    = println(value)
  }
}

object App2 {
  case class Cat(name: String, age: Int)
  import PrintableInstances._
  implicit val catPrintable = new Printable[Cat] {
    def format(cat: Cat) = {
      val name  = Printable.format(cat.name)
      val age   = Printable.format(cat.age)
      s"$name is a $age year-old cat."
    }
  }
  def main(args: Array[String]): Unit = {}
}

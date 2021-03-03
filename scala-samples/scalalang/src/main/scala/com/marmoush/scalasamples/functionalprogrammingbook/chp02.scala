package com.marmoush.scalasamples.functionalprogrammingbook

class chp02 {
  val k       = 2323
  val hellooo = 2323

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C = (b: B) => f(a, b)

  def curry[A, B, C](f: (A, B) => C): A => (B => C) = (a: A) => ((bla) => f(a: A, bla: B))

}

object FormatMe {
  val number = 3
  List(number) match {
    case head :: Nil if head % 2 == 0 => "number is even"
    case head :: Nil =>
      "number is not even"
    case Nil =>
      "List is empty"
  }

}

package com.marmoush.scalasamples.concepts

object Linearization3 {

  def main(args: Array[String]) {
    var x = new X
    println()
    println(x.foo)
  }
}

class A {
  print("A")

  def foo() = "A"
}

trait B extends A {
  print("B")

  override def foo() = super.foo() + "B"
}

trait C extends B {
  print("C")

  override def foo() = super.foo() + "C"
}

trait D extends A {
  print("D")

  override def foo() = super.foo() + "D"
}

class X extends A with D with C with B

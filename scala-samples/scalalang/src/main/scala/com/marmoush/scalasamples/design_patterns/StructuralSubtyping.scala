package com.marmoush.scalasamples.design_patterns

/**
  * Similar to duck typing
  */
object StructuralSubtyping {

  def quacker(duck: { def quack(value: String): String }) {
    println(duck.quack("Quack"))
  }

  def callSpeak[A <: { def speak(): Unit }](obj: A) {
    // code here ...
    obj.speak()
  }
}

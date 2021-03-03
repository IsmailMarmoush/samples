package com.marmoush.scalasamples.concepts

import com.marmoush.scalasamples.helpers.Rational

object ImplicitConversion {
  println("Welcome to the Scala worksheet")

  //> Welcome to the Scala worksheet

  //> intToRational: (x: Int)com.marmoush.scalasamples.helpers.Rational
  val r = new Rational(2, 3) //> r  : com.marmoush.scalasamples.helpers.Rational = com.marmoush.scalasamples.

  implicit def intToRational(x: Int) = new Rational(x, 1)
  //| helpers.Rational@2521ddb8
  2 * r //> res0: com.marmoush.scalasamples.helpers.Rational = com.marmoush.scalasamples
  //| .helpers.Rational@52636e13
  /*Note that for an implicit conversion to work, it needs to be in scope. If you place the implicit method definition inside class Rational, it won’t be in scope in the interpreter. For now, you’ll need to define it directly in the interpreter.*/

}
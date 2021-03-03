package com.marmoush.scalasamples.concepts.FunAndMeth

import com.marmoush.scalasamples.helpers.Rational

object ImplicitParametersUsage {
  println("Welcome to the Scala worksheet")

  //> Welcome to the Scala worksheet
  // ## Where implicits are used
  val i: Int = 3.5 //> i  : Int = 3
  /** Conversions of the receiver of a selection **/
  // Interoperating with new types:

  val oneHalf = new Rational(1, 2)

  /** Conversions to an expected type **/

  implicit def doubleToInt(x: Double) = x.toInt //> doubleToInt: (x: Double)Int

  //> oneHalf  : com.marmoush.scalasamples.helpers.Rational = com.marmoush.scalasa
  //| mples.helpers.Rational@7bce6a36
  // 1 is not rational so it will produce an error
  // 1 + oneHalf
  // but if we do this:
  implicit def intToRational(x: Int) = new Rational(x, 1)

  //> intToRational: (x: Int)com.marmoush.scalasamples.helpers.Rational
  // it will convert 1 into a rational
  1 + oneHalf //> res0: com.marmoush.scalasamples.helpers.Rational = com.marmoush.scalasamples
  //| .helpers.Rational@2c9f3eba

  // Simulating the "new" syntax

  Map(1 -> "one", 2 -> "two", 3 -> "three") //> res1: scala.collection.immutable.Map[Int,String] = Map(1 -> one, 2 -> two, 3
  //|  -> three)
  // because

  /*
	package scala
	object Predef {
		class ArrowAssoc[A](x: A) {
			def -> [B](y: B): Tuple2[A, B] = Tuple2(x, y)
		}
		implicit def any2ArrowAssoc[A](x: A): ArrowAssoc[A] =
		new ArrowAssoc(x)
	}
	*/

}
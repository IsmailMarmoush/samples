package com.marmoush.scalasamples.samples

object TypeErasure {

  val as = Array("abc") //> as  : Array[String] = Array(abc)
  val ai = Array(1, 2, 3) //> ai  : Array[Int] = Array(1, 2, 3)

  def isStringArray(x: Any) = x match {
    case a: Array[String] => "yes"
    case _ => "no"
  } //> isStringArray: (x: Any)String

  abstract class Expr

  case class Var(name: String) extends Expr

  //Type Erasure//
  // http://stackoverflow.com/questions/313584/what-is-the-concept-of-erasure-in-generics-in-java

  //  scala -unchecked
  // Welcome to Scala version 2.8.1
  // (Java HotSpot(TM) Client VM, Java 1.5.0_13).
  // Type in exp// ressions to have them evaluated.
  // Type :help for more information.

  /* def isIntIntMap(x: Any) = x match {
    case m: Map[Int, Int] => true
    case _ => false
  }

  isIntIntMap(Map(1 -> 1))
  // res19: Boolean = true
  isIntIntMap(Map("abc" -> "abc"))
  // res20: Boolean = true
	
	*/


  // The only exception to the erasure rule is arrays:

  case class Number(num: Double) extends Expr

  case class UnOp(operator: String, arg: Expr) extends Expr

  isStringArray(as)
  //> res0: String = yes

  case class BinOp(operator: String,
                   left: Expr, right: Expr) extends Expr

  isStringArray(ai) //> res1: String = no

  //Variable Binding//

  /*expr match {
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case _ =>
  }*/

}
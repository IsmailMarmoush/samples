package com.marmoush.scalasamples.concepts

/**
  * http://docs.scala-lang.org/tutorials/tour/pattern-matching.html
  */
object PatternMatching {}

object MatchTest1 {

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }

  println(matchTest(3))
}

object MatchTest2 extends App {

  def matchTest(x: Any): Any = x match {
    case 1      => "one"
    case "two"  => 2
    case y: Int => "scala.Int"
  }

  println(matchTest("two"))
}

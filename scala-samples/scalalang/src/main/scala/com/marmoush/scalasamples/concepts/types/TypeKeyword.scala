package com.marmoush.scalasamples.concepts.types

/**
  * http://stackoverflow.com/questions/19492542/understanding-what-type-keyword-does-in-scala
  */
object TypeAlias {
  type FunctorType = (Double, Int, Int, Boolean) => Double

  def doSomeThing(f: FunctorType) = 3.5

  // is same as:
  def doSomeThing1(f: (Double, Int, Int, Boolean) => Double) = 3.5
}

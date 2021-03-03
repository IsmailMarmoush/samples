package com.marmoush.scalasamples.concepts

object Currying {

  def main(args: Array[String]): Unit = {
    def plainOldSum(x: Int, y: Int) = x + y
    plainOldSum(1, 2)
    def curriedSum(x: Int)(y: Int) = x + y
    curriedSum(1)(2)
    def first(x: Int) = (y: Int) => x + y
    val second        = first(1)
    second(2)
    val onePlus = curriedSum(1) _
    onePlus(2)
    val twoPlus = curriedSum(2) _
    twoPlus(2)
  }

  def twice(op: Double => Double, x: Double) = op(op(x))

  def twiceBetter(op: Double => Double) = (op + "").toDouble

}

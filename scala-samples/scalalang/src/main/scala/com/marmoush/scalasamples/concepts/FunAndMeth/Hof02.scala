package com.marmoush.scalasamples.concepts.FunAndMeth

object Vid01Hof {

  def id(x: Int): Int = x

  def fact(x: Int): Int = {
    def fact(number: Int, accumulator: Int): Int = {
      if (number == 1)
        return accumulator
      fact(number - 1, number * accumulator)
    }
    fact(x, 1)
  }

  def cube(x: Int): Int = x * x * x

  def sumInts(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInts(a + 1, b)

  def sumCubes(a: Int, b: Int): Int =
    if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

  def sumFactorials(a: Int, b: Int): Int =
    if (a > b) 0 else fact(a) + sumFactorials(a + 1, b)

  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)

  def main(args: Array[String]) {
    println(sumInts(3, 7))
    println(sumCubes(3, 7))
    println(sumFactorials(3, 7))
    println(fact(4))
  }
}

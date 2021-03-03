package com.marmoush.scalasamples.concepts.FunAndMeth

object TailRecursion {
  println("Welcome to the Scala worksheet")

  //> Welcome to the Scala worksheet

  def bang(x: Int): Int =
    if (x == 0) throw new Exception("bang!")
    else bang(x - 1) //> bang: (x: Int)Int
  /** Limits of tail recursion **/

  def isEven(x: Int): Boolean =
    if (x == 0) true else isOdd(x - 1)

  //> isEven: (x: Int)Boolean
  def isOdd(x: Int): Boolean =
    if (x == 0) false else isEven(x - 1) //> isOdd: (x: Int)Boolean

  // You also won’t get a tail-call optimization if the final call goes to a function value. Consider for instance the following recursive code:

  def nestedFun(x: Int) {
    val funValue = nestedFun _
    if (x != 0) {
      println(x); funValue(x - 1)
    }
  } //> nestedFun: (x: Int)Unit
  nestedFun(10) //> 10
  //| 9
  //| 8
  //| 7
  //| 6
  //| 5
  //| 4
  //| 3
  //| 2
  //| 1
}
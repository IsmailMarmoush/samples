package com.marmoush.scalasamples.samples

object PlaceHolder {
  println("Welcome to the Scala worksheet") //> Welcome to the Scala worksheet
  List(1, 3, 34, 0).filter(_ > 0) //> res0: List[Int] = List(1, 3, 34)
  // Is equivlent to
  List(1, 3, 34, 0).filter(x => x > 0)
  //> res1: List[Int] = List(1, 3, 34)
  // You can't do:
  // val f = _ + _
  // But you can:
  val f = (_: Int) + (_: Int) //> f  : (Int, Int) => Int = <function2>
}
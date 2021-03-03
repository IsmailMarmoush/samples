package com.marmoush.scalasamples

object ForComprehension {

  def main(args: Array[String]): Unit = {
    example1
    println("")
    example2
    println("")
    example3
  }

  val a1 = List(1, 2, 3)
  val a2 = List(4, 5, 6)
  val a3 = List(7, 8, 9)

  val b1 = a1.map(Option(_))
  val b2 = a2.map(Option(_))
  val b3 = a3.map(Option(_))

  def example1(): Unit = {
    for (x <- a1; y <- a2; z <- a3) {
      print(s"($x , $y , $z)")
    }
    // c1.foreach(x => c2.foreach(y => c3.foreach(z => {...})))
  }

  def example2(): Unit = {
    for (x <- a1; y <- a2; z <- a3) yield {
      print(s"($x , $y , $z)")
    }
  }

  def example3(): Unit = {
    val result = for (x <- b1; y <- b2; z <- b3) yield {
      (x, y, z)
    }
    println(result)
    // b1.flatMap((x: _root_.scala.Option[Int]) => b2.flatMap((y: _root_.scala.Option[Int]) => b3.map((z: _root_.scala.Option[Int]) => Tuple3.apply(x, y, z))(List.canBuildFrom))(List.canBuildFrom))(List.canBuildFrom)

  }
}

package com.marmoush.scalasamples.hackerrank.functional.recursion

object Switch {

  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readLine()
    def f10(lst: List[Char], n: List[Char]): List[Char] = lst match {
      case Nil => n
      case _   => f10(lst.tail.tail, lst.head :: lst.tail.head :: n)
    }
    1.to(n.toInt).foreach { x =>
      println(f10(scala.io.StdIn.readLine().toList, Nil).reverse.mkString)
    }
  }
}

package com.marmoush.scalasamples.hackerrank.functional

import scala.annotation.tailrec

/**
  * pascal triangle: r! / (c! * (r-c)!)
  */
object PascalTriangle {

  def main(args: Array[String]): Unit = {
    // val i = scala.io.StdIn.readInt()
    pascalTriangle(4)
  }

  @tailrec
  def factorial(n: Int, accumulator: Long = 1): Long = {
    if (n == 0) accumulator else factorial(n - 1, (accumulator * n))
  }

  def pascalTriangle(i: Int) = {
    0.to(i - 1).foreach { r =>
      0.to(r).foreach { c =>
        print(factorial(r) / (factorial(c) * factorial(r - c)) + " ")
      }
      println
    }
  }
}

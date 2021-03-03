package com.marmoush.scalasamples.hackerrank.functional

import scala.annotation.tailrec

object Factorial {

  def f8(x: Float): Float = {
    @tailrec
    def factorial(n: Int, accumulator: Long = 1): Long = {
      if (n == 0) accumulator else factorial(n - 1, (accumulator * n))
    }
    0.to(10)
      .map { i =>
        (scala.math.pow(x, i) / factorial(i, 1)).toFloat
      }
      .sum
  } //> f8: (x: Float)Float
  println(f8(52) / (f8(40) * f8(12))) //> 2.276167E-4

}

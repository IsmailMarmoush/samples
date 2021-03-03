package com.marmoush.scalasamples.hackerrank.functional

import scala.annotation.tailrec

object Fibonacci {

  def main(args: Array[String]): Unit = {
    def fibonacci(x: Int): Int = {
      @tailrec
      def fib(m: Int, n: Int, k: Int): Int = k match {
        case 1 => m
        case i => fib(m + n, m, k - 1)
      }
      fib(0, 1, x)
    }
    System.out.println(fibonacci(5))
  }
}

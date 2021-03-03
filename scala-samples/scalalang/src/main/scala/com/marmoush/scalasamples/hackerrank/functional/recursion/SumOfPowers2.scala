package com.marmoush.scalasamples.hackerrank.functional.recursion

import scala.math.pow

object SumOfPowers2 {

  def ways(X: Int, prev: Int, N: Int): Int = X match {
    case x if x < 0 => 0
    case 0 | 1      => 1
    case _ =>
      (prev to 2 by -1).map(x => (x, X - pow(x, N).toInt)).map(x => ways(x._2, x._1 - 1, N)).sum
  }

  def numberOfWays(X: Int, N: Int): Int = ways(X, pow(X, 1d / N).toInt, N)

  def main(args: Array[String]) {
    println(numberOfWays(readInt(), readInt()))
  }
}

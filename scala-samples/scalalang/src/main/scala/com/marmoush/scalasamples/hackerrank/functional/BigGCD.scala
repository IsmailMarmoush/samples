package com.marmoush.scalasamples.hackerrank.functional

import scala.annotation.tailrec
import scala.math.BigInt

object BigGCD {

  def main(args: Array[String]): Unit = {

    @tailrec
    def gcd(x: BigInt, y: BigInt): BigInt = {
      if (x == BigInt(0))
        y
      else
        gcd(y % x, x)
    }

    scala.io.StdIn.readInt()
    val a = scala.io.StdIn
      .readLine()
      .split(" ")
      .toList
      .map {
        BigInt(_)
      }
      .reduce(_ * _)
    scala.io.StdIn.readInt()
    val b = scala.io.StdIn
      .readLine()
      .split(" ")
      .toList
      .map {
        BigInt(_)
      }
      .reduce(_ * _)

    println(gcd(a, b) % BigInt(1000000007))
  }
}

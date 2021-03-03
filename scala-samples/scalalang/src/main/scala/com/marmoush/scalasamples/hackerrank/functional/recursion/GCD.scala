package com.marmoush.scalasamples.hackerrank.functional.recursion

import scala.annotation.tailrec

/**
  * Greatest Common Divisor
  */
object GCD {

  def main(args: Array[String]): Unit = {
    @tailrec
    def gcd(x: Long, y: Long): Long = x match {
      case 0 => y
      case i => gcd(y % i, x)
    }
    println(gcd(3768, 1701))

  }

}

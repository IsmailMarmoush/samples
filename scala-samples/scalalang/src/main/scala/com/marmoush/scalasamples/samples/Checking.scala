package com.marmoush.scalasamples.samples

object Checking {

  class Rational(n: Int, d: Int) {
    require(d != 0)

    override def toString = n + "/" + d
  }

}

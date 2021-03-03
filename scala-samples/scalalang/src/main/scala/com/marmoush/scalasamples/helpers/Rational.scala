package com.marmoush.scalasamples.helpers

class Rational(n: Int, d: Int) {
  val numer: Int = n / g
  val denom: Int = d / g
  private val g  = gcd(n, d)

  def +(that: Rational) =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def -(that: Rational) =
    new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

  def *(that: Rational) =
    new Rational(numer * that.numer, denom * that.denom)

  def /(that: Rational) =
    new Rational(numer * that.denom, denom * that.numer)

  private def gcd(x: Int, y: Int): Int =
    if (x == 0) y
    else if (x < 0) gcd(-x, y)
    else if (y < 0) -gcd(x, -y)
    else gcd(y % x, x)
}

package com.marmoush.scalasamples.hackerrank.functional.recursion

object PrefixCompression {

  def main(args: Array[String]) = {
    val a = "abcdefpr".toList
    val b = "abcpqr".toList
    val c = a.zip(b).takeWhile { case (x, y) => x == y }.map { case (x, _) => x }.mkString

    val a2 = a.drop(c.length()).mkString
    val b2 = b.drop(c.length()).mkString
    println(c.length + " " + c)
    println(a2.length + " " + a2)
    println(b2.length + " " + b2)
    val com = a.distinct.combinations(2)
    com.foreach {
      println
    }
  }
}

package com.marmoush.scalasamples.hackerrank.functional

object NewMissingNumbers {

  def main(args: Array[String]): Unit = {
    scala.io.StdIn.readInt()
    val a = scala.io.StdIn.readLine().split(" ").toList.map {
      _.toInt
    }
    scala.io.StdIn.readInt()
    val b = scala.io.StdIn.readLine().split(" ").toList.map {
      _.toInt
    }
    println((b diff a).distinct.sortWith(_.compareTo(_) < 0).mkString(" "))
  }
}

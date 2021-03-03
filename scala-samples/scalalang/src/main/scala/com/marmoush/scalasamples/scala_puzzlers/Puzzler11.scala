package com.marmoush.scalasamples.scala_puzzlers

/**
  * Created by spark on 11/18/15.
  */
object Puzzler11 {

  def main(args: Array[String]) {
    var x      = 0
    lazy val y = 1 / x
    try {
      println(y)
    } catch {
      case _: Exception =>
        x = 1
        println(y)

    }
  }
}

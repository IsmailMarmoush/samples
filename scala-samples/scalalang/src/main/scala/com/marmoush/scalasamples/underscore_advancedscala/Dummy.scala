package com.marmoush.scalasamples.underscore_advancedscala

object Dummy {

  def main(args: Array[String]): Unit = {
    val l  = List(1, 3, 3, 5)
    val l2 = List(2, 3, 4, 5)
    l.map((i: Int) => println(i))(List.canBuildFrom)
  }
}

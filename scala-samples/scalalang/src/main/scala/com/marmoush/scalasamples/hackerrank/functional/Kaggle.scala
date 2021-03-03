package com.marmoush.scalasamples.hackerrank.functional

object Kaggle {

  def main(args: Array[String]) {
    val total = 4100
    // val x = 3
    val list = List(3, 5)
    println(
      list
        .flatMap(x => {
          1.to((total - 1) / x).map(_ * x)
        })
        .sum
    )

    // val m = 1.to((total - 1) / x).map(_ * x).sum
    // println(m)
  }
}

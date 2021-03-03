package com.marmoush.scalasamples.samples

object Operators {

  def main(args: Array[String]) {
    println(MyOp(3) -- MyOp(2))
    println(MyOp(3) --: MyOp(2))
  }

  case class MyOp(k: Int) {

    // Reverse method applies to right side
    def --:(x: MyOp) = {
      this.k - x.k
    }

    def --(x: MyOp) = {
      this.k - x.k
    }
  }
}

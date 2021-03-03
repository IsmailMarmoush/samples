package com.marmoush.scalasamples.samples

object Chp02 {

  def main(args: Array[String]) {
    args.foreach((arg: String) => println(arg))
    args.foreach(println)
    val greetStrings: Array[String] = new Array[String](3)

    // The operator "<-"  can be called in, arg is also a val nor var
    for (arg <- args)
      println(arg)

  }
}

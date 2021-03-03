package com.marmoush.scalasamples.concepts

/**
  * http://www.tutorialspoint.com/scala/scala_extractors.htm
  */
object Extractors {

  def main(args: Array[String]) {
    val s = Some(2)

    val x = Test(5)
    println(x)

    val k = x match {
      //unapply is invoked
      case Test(num) => x + " is bigger two times than " + num
      case _         => x
    }
    println(k)
  }

  object Test {
    def apply(x: Int) = x * 2

    def unapply(z: Int): Option[Int] = if (z % 2 == 0) Some(z / 2) else None
  }

}

package com.marmoush.scalasamples.functionalprogrammingbook

object chp06 {

  trait RNG {
    def nextInt: (Int, RNG)
  }

  type Rand[+A] = RNG => (A, RNG)

  val int: Rand[Int] = _.nextInt


  case class SimpleRNG(seed: Long) extends RNG {
    def nextInt: (Int, RNG) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
      val nextRNG = SimpleRNG(newSeed)
      val n = (newSeed >>> 16).toInt
      (n, nextRNG)
    }
    

    def unit[A](a: A): Rand[A] = rng => (a, rng)

    def map[A, B](s: Rand[A])(f: A => B): Rand[B] =
      rng => {
        val (a, rng2) = s(rng)
        (f(a), rng2)
      }
//    def nonNegativeInt(rng: RNG): (Int, RNG) =
//    def nonNegativeEven: Rand[Int] = map(nonNegativeInt)(i => i - i % 2)
  }


  def main(args: Array[String]): Unit = {
    val rng = SimpleRNG(42)
    print(rng)
  }

}


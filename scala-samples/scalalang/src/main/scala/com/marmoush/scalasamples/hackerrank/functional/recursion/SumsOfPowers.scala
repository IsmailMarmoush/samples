package com.marmoush.scalasamples.hackerrank.functional.recursion

import scala.annotation.tailrec

object SumsOfPowers {

  def main(args: Array[String]): Unit = {
    val x   = 100 // total  1:1000
    val n   = 2 // exp 2:10
    val max = math.pow(x, (1d / n)).toInt

    // println(max)
    val pow = 1
      .to(max)
      .map {
        math.pow(_, n).toInt
      }
      .toList
    // println("Power:" + pow)

    def sums(c: List[Int]) = {
      @tailrec
      def f(c: List[Int], res: List[Int] = List(0)): List[Int] = c match {
        //println(s"op: $res + $x = ${res + x}")
        case Nil => res
        case _   => f(c.tail, c.head + res.head :: res)
      }
      f(c).reverse.tail
    }
    val sum = 0 :: sums(pow)
    //    println("Sum:" + sum)
    val minimaIndex =
      (sum, pow).zipped.map(_ + _).zipWithIndex.maxBy(_._1 > x)._2
    val minima = pow(minimaIndex)
    // println("minima:" + minima)

    def oneComb(total: Int, head: Int, tee: List[Int]): List[List[Int]] = {
      val min = total - head
      val c = tee.dropWhile {
        _ > min
      }
      // println(s"Searching total($total)-($head) - sum of any combination in $c")
      1.to(c.length).map {
        c.combinations(_)
          .filter {
            _.sum == min
          }
          .toList
          .map {
            head :: _
          }
      }
    }.flatten.toList

    val powRev = pow.reverse
    def allCombs(x: Int, minima: Int, l: List[Int], res: List[List[Int]]): List[List[Int]] = l match {
      case Nil                    => res
      case l if (l.head < minima) => res
      case _ =>
        allCombs(x, minima: Int, l.tail, oneComb(x, l.head, l.tail) ++ res)
    }
    val r = allCombs(x, minima, powRev, Nil)
    val p = if (math.pow(max, n).toInt == x) r.length + 1 else r.length
    println(p)

    //    println("PowRev"+powRev)
    //    def combs(x: Int, powRev: List[Int], res: List[List[Int]]): List[List[Int]] = powRev match {
    //      case Nil => res
    //      case _ => {
    //        println("head"+powRev.head)
    //        val m = combs(x, powRev.tail, oneComb(x - powRev.head, powRev.tail) ++ res)
    //        println("m"+m)
    //        m.filter { x - powRev.head - _.sum == 0 }
    //      }
    //    }
    //    println("------------------")
    //    val ccc=combs(x,powRev,Nil)
    //    println(ccc)
    //    //    val combs1 = oneComb(x - powRev.head, powRev.tail)
    //    //    println(combs1.filter { x - powRev.head - _.sum == 0 })
    //
    //    // minima.until(pow.length).map { x => ??? }

  }

  def calc = {
    @tailrec
    def factorial(n: Int, accumulator: Long = 1): Long = {
      if (n == 0) accumulator else factorial(n - 1, (accumulator * n))
    }
    def ncr(n: Int, r: Int) = factorial(n) / (factorial(r) * factorial(n - r))
    def allNcr(n: Int) = {
      for (x <- 1 until n) yield ncr(n, x)
    }.sum
    // println(allNcr(10))
    // 2.to(10).foreach { x => println(allNcr(x)) }
  }
}

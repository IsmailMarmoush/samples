package com.marmoush.scalasamples.hackerrank.functional

object Misc {

  def main(args: Array[String]) {
    def f1(n: Int) = n.to(1, -1).foreach { x =>
      println("Hello World")
    }
    //    io.Source.stdin.getLines().take(1).map(_.toInt).foreach(x => x.to(1,-1).foreach { x => println("Hello World") })
    def f2(num: Int, arr: List[Int]): List[Int] = arr.flatMap(List.fill(num)(_))
    def f3(delim: Int, arr: List[Int]): List[Int] = arr.filter {
      _ < delim
    }
    def f4(arr: List[Int]): List[Int] = arr.zipWithIndex.collect {
      case (x, i) if i % 2 != 0 => x
    }
    println(f4(List(2, 5, 3, 4, 6, 7, 9, 8)))
    def f5(n: Int): List[Int] = List.fill(n)(n)
    def f6(arr: List[Int]): Int =
      arr.filter { x =>
        x % 2 != 0
      }.sum
    def f7(arr: List[Int]): List[Int] = arr.map(_.abs)

    def f9(s1: String, s2: String): String =
      s1.toList.zip(s2.toList).flatten { case (x, y) => x + "" + y }.mkString
    println(f9("abcd", "xwyz"))

    println(60 % 100000007)
    val cases = scala.io.StdIn.readLine().toInt

    for (i <- 1 to cases) {
      val size :: n :: Nil = scala.io.StdIn.readLine().split(' ').toList.map {
        _.toInt
      }

      val l = scala.io.StdIn.readLine().split(' ').toList.map {
        _.toInt
      }
      val res = l.distinct
        .map { x =>
          (x, l.count {
            _ == x
          })
        }
        .filter(_._2 >= n)
        .map(_._1)
      if (res.isEmpty)
        println(-1)
      else
        println(res.mkString(" "))
    }

  }
}

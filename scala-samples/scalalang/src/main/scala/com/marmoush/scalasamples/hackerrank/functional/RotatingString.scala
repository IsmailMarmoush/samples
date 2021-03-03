package com.marmoush.scalasamples.hackerrank.functional

object RotatingString {

  def main(args: Array[String]): Unit = {
    def f10(s1: String): String = {
      def loop(s1: String, s2: List[String], acc: Int): List[String] =
        acc match {
          case 0 => s2
          case i => loop(s1.tail + s1.head, List.concat(s2, s1 :: Nil), i - 1)
        }
      val l = loop(s1, Nil, s1.length)
      ((l.tail).mkString(" ") + " " + l.head).trim()
    }
    val i = scala.io.StdIn.readInt()
    1.to(i).foreach { x =>
      println(f10(scala.io.StdIn.readLine()))
    }

  }
}

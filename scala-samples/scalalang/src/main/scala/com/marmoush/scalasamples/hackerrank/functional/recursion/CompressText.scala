package com.marmoush.scalasamples.hackerrank.functional.recursion

object CompressText {

  def main(args: Array[String]): Unit = {
    // Try with  aaabbbcccdddccccaaaadddffff
    def add(c: Char, res: List[(Char, Int)]): List[(Char, Int)] = res match {
      //println(s"op: $res + $x = ${res + x}")
      case Nil => (c, 1) :: Nil
      case _ =>
        if (c == res.head._1) (c, res.head._2 + 1) :: res.tail
        else (c, 1) :: res
    }
    val dup = scala.io.StdIn.readLine().foldRight[List[(Char, Int)]](Nil)(add)
    println(dup.flatMap(x => if (x._2 != 1) x._1 + "" + x._2 else x._1 + "").mkString)

  }
}

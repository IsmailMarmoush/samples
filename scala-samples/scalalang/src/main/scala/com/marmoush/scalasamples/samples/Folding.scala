package com.marmoush.scalasamples.samples

/**
  *
  *
  * <a href="http://oldfashionedsoftware.com/2009/07/30/lots-and-lots-of-foldleft-examples"/>Folding Examples</a>
  * <a href="http://oldfashionedsoftware.com/2009/07/10/scala-code-review-foldleft-and-foldright/">When to fold</a>
  */
object Folding {

  def main(args: Array[String]): Unit = {
    val list = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    println(list)
    println(sum(list))
    println(sub(list))
  }

  def sum(list: List[Int]): Int = list.foldLeft(2)(_ + _)

  def sub(list: List[Int]): Int = list.foldLeft(0)(_ - _)
}

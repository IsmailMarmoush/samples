package com.marmoush.scalasamples.concepts

object caching {

  import scala.collection.mutable.WeakHashMap

  val cache = new WeakHashMap[Int, Int]
  //> fibonacci_ : (in: Int)Int
  val fibonacci: Int => Int = memo(fibonacci_) //> fibonacci  : Int => Int = <function1>

  //> memo: (f: Int => Int)Int => Int
  val t1 = System.currentTimeMillis() //> t1  : Long = 1445904767093
  val t2 = System.currentTimeMillis() //> t2  : Long = 1445904767659

  //> cache  : scala.collection.mutable.WeakHashMap[Int,Int] = Map()
  def memo(f: Int => Int) = (x: Int) => cache.getOrElseUpdate(x, f(x))
  println(fibonacci(40)) //> 102334155
  println("it takes " + (System.currentTimeMillis() - t1) + "ms")
  //> it takes 566ms

  def fibonacci_(in: Int): Int = in match {
    case 0 => 0;
    case 1 => 1;
    case n: Int => fibonacci_(n - 1) + fibonacci_(n - 2)
  }
  println(fibonacci(40)) //> 102334155
  println("it takes " + (System.currentTimeMillis() - t2) + "ms")
  //> it takes 0ms
}
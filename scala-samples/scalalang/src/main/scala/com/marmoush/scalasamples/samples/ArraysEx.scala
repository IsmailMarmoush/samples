package com.marmoush.scalasamples.samples

object Chp03 {

  def main(args: Array[String]) {
    // Arrays
    val greetStrings = new Array[String](3)
    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"
    for (i <- 0 to 2)
      print(greetStrings(i))
    //
    val greetStrings2 = new Array[String](3)
    greetStrings2.update(0, "Hello")
    greetStrings2.update(1, ", ")
    greetStrings2.update(2, "world!\n")
    for (i <- 0.to(2))
      print(greetStrings2.apply(i))

    val numNames2 = Array.apply("zero", "one", "two")

    // Lists
    val oneTwo          = List(1, 2)
    val threeFour       = List(3, 4)
    val oneTwoThreeFour = oneTwo ::: threeFour
    println(oneTwo + " and " + threeFour + " were not mutated.")
    println("Thus, " + oneTwoThreeFour + " is a new list.")

    val twoThree    = List(2, 3)
    val oneTwoThree = 1 :: twoThree
    println(oneTwoThree)

    val quick = 1 :: 2 :: 3 :: Nil
    println(quick)

    val thrill = "Will" :: "fill" :: "until" :: Nil

    val pair = (99, "Luftballons")
    println(pair._1)
    println(pair._2)

    val k = for {
      a <- 1 to 3
      b <- 1 to 3
    } yield (a, b)
    println(k)
    import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.Future
    val k1 = Future {
      //Thread.sleep(10000)
      2000
    }

    k1 onSuccess {
      case x => println(x)

    }

  }
}

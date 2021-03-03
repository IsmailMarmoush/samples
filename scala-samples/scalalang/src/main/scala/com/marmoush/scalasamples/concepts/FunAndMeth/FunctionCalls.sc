package com.marmoush.scalasamples.concepts.FunAndMeth

object FunctionCalls {

  println("Welcome to the Scala worksheet")

  //> Welcome to the Scala worksheet

  //> echo: (args: String*)Unit
  val arr = Array("What's", "up", "doc?") //> arr  : Array[String] = Array(What's, up, doc?)

  /** ********* Repeated Parameters *************/
  def echo(args: String*) = for (arg <- args) {
    println(arg)
  }
  // The following is wrong
  // echo(arr)
  // The following is right
  echo(arr: _*)

  //> What's
  //| up
  //| doc?

  /** ********* Named Arguments *************/
  // Named arguments allow you to pass arguments to a function in a different order
  def speed(distance: Float, time: Float): Float = distance / time

  //> speed: (distance: Float, time: Float)Float
  speed(100, 10) //> res0: Float = 10.0
  speed(distance = 100, time = 10)

  //> res1: Float = 10.0

  /** ********* Default parameter values *************/
  def printTime(out: java.io.PrintStream = Console.out) =
    out.println("time = " + System.currentTimeMillis())

  //> printTime: (out: java.io.PrintStream)Unit

  def printTime2(out: java.io.PrintStream = Console.out, divisor: Int = 1) =
    out.println("time = " + System.currentTimeMillis() / divisor)

  //> printTime2: (out: java.io.PrintStream, divisor: Int)Unit

  printTime2(out = Console.err) //> time = 1433616222785
  printTime2(divisor = 1000) //> time = 1433616222

}
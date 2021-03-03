package com.marmoush.scalasamples.samples

object OptionType {
  //> g: (v: Int)List[Int]
  val l = List(1, 2, 3, 4, 5) //> l  : List[Int] = List(1, 2, 3, 4, 5)
  val x = Option(3)
  println(l.flatMap {
    g
  })

  //> List(0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 4, 5, 4, 5, 6)
  // is same as Option.apply(3) //> x  : Option[Int] = Some(3)
  val k = x match {
    case Some(s) => s
    case None => "?"
  } //> k  : Any = 3
  println(l.map {
    f
  }) //> List(None, None, Some(3), Some(4), Some(5))
  println(l.flatMap {
    f
  })
  //> List(3, 4, 5)
  /** *********************************************************************************/

  val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

  def g(v: Int) = List(v - 1, v, v + 1)

  // List of options
  // options are considered a sequence with one value or none
  def f(x: Int) = if (x > 2) Some(x) else None //> f: (x: Int)Option[Int]
  //> capitals  : scala.collection.immutable.Map[String,String] = Map(France -> Pa
  //| ris, Japan -> Tokyo)
  capitals get "France" //> res0: Option[String] = Some(Paris)

  capitals get "North Pole"

  //> res1: Option[String] = None

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  } //> show: (x: Option[String])String
  show(capitals get "Japan") //> res2: String = Tokyo
  show(capitals get "France") //> res3: String = Paris
  show(capitals get "North Pole") //> res4: String = ?
}
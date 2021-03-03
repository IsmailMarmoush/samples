package com.marmoush.scalasamples.concepts.FunAndMeth

object MethUnitReturn {
  println("Welcome to the Scala worksheet")

  //> Welcome to the Scala worksheet
  def f(): Unit = "this String gets lost"

  //> f: ()Unit
  def g() {
    "this String gets lost too"
  }

  //> g: ()Unit
  // both previous aren't the same as the following, note the "=" sign
  def h() = {
    "this String gets returned!"
  } //> h: ()String
}
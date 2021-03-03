package com.marmoush.scalasamples.concepts.FunAndMeth

object ImplicitParameters {
  println("Welcome to the Scala worksheet")

  //> Welcome to the Scala worksheet

  // explicitly
  val bobsPrompt = new PreferredPrompt("relax> ") //> bobsPrompt  : com.marmoush.scalasamples.concepts.FunAndMeth.ImplicitParamete

  class PreferredPrompt(val preference: String)

  object Greeter {
    def greet(name: String)(implicit prompt: PreferredPrompt) {
      println("Welcome, " + name + ". The system is ready.")
      println(prompt.preference)
    }
  }
  //| rs.PreferredPrompt = com.marmoush.scalasamples.concepts.FunAndMeth.ImplicitP
  //| arameters$$anonfun$main$1$PreferredPrompt$1@7f416b2d
  Greeter.greet("Bob")(bobsPrompt)

  //> Welcome, Bob. The system is ready.
  //| relax>

  // implicitly
  object JoesPrefs {
    implicit val prompt = new PreferredPrompt("Yes, master> ")
  }

  import JoesPrefs._

  Greeter.greet("Joe") //> Welcome, Joe. The system is ready.
  //| Yes, master>

  /** Note: implicit keyword applies to an entire parameter list, not to individual parameters. */
}
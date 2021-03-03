package com.marmoush.scalasamples.concepts.FunAndMeth

/**
  * http://stackoverflow.com/questions/28118146/scala-passing-function-with-underscore-produces-a-function-not-a-value
  */
object HOFsVariations {

  def main(args: Array[String]): Unit = {
    def g(v: Int) = List(v - 1, v, v + 1)
    val l         = List(1, 2, 3, 4, 5)
    // map with some variations
    println(l.map { (x) =>
      g(x)
    })
    println(l.map { x =>
      g(x)
    })
    println(l.map {
      g(_)
    }) // g(_). That is a syntactic sugar for x => g(x)

    // different but gives same output
    println(l.map {
      g
    }) //  g and x => g(x) are not the same thing.

    // different and gives different output
    println(l.map { (_: Int) =>
      g(_)
    }) // l.map { (unusedVar: Int) => (x => g(x)) }
    println(l.map { (_) =>
      g(_)
    })

    // apply unit function
    println(l.map { _ =>
      })
    println(l.map { _ =>
      ()
    })

  }
}

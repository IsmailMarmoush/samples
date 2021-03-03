package com.marmoush.scalasamples.concepts

object Traits {
  println("Welcome to the Scala worksheet")

  //> Welcome to the Scala worksheet

  // Turn thin interface into rich interface, example usage of Ordered trait

  // ## Traits as stackable modification

  val queue = (new BasicIntQueue with Filtering with Incrementing)

  import scala.collection.mutable.ArrayBuffer

  trait Doubling extends IntQueue {
    abstract override def put(x: Int) {
      super.put(2 * x)
    }
  }

  trait Incrementing extends IntQueue {
    abstract override def put(x: Int) {
      super.put(x + 1)
    }
  }

  trait Filtering extends IntQueue {
    abstract override def put(x: Int) {
      if (x >= 0) super.put(x)
    }
  }

  abstract class IntQueue {
    def get(): Int

    def put(x: Int)
  }

  class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]

    def get() = buf.remove(0)

    def put(x: Int) {
      buf += x
    }
  }

  //> queue  : com.marmoush.scalasamples.concepts.Traits.BasicIntQueue with com.ma
  //| rmoush.scalasamples.concepts.Traits.Filtering with com.marmoush.scalasamples
  //| .concepts.Traits.Incrementing = com.marmoush.scalasamples.concepts.Traits$$a
  //| nonfun$main$1$$anon$1@aaf8eaa

  queue.put(-1);
  queue.put(0);
  queue.put(1)
  queue.get() //> res0: Int = 0

  queue.get() //> res1: Int = 1

  queue.get() //> res2: Int = 2

}
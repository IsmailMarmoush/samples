package com.marmoush.scalasamples.concepts

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future, Promise, _}
import scala.concurrent.duration._

object ScalaFuture {

  def main(args: Array[String]) {
    val p = Promise[Int]()
    val future = Future {
      println("Starting the new legislative period.")
      Thread.sleep(2000)
      p.success(20)
      //p.failure(new NullPointerException)
      println("We reduced the taxes! You must reelect us!!!!1111")
    }
    p.future.onFailure { case r => println(r) }
    p.future.onSuccess { case r => println(r) }
    Await.ready(future, Duration.Inf)
    m1

  }

  def m1 = {
    0 until 10 map { i =>
      Future {
        blocking {
          Thread.sleep(1000);
          println(i)
        }
      }
    }
  }
}

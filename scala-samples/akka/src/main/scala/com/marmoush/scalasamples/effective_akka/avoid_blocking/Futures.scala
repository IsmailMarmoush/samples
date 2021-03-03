package com.marmoush.scalasamples.effective_akka.avoid_blocking

import akka.actor.{Actor, ActorSystem, Props}

//import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.{ExecutionContext, Future}

object Futures {
  def main(args: Array[String]) {
    val system = ActorSystem("helloakka")
    //    implicit val ec: ExecutionContext = system.dispatcher
    implicit val ec: ExecutionContext = com.marmoush.scalasamples.Contexts.simpleDbLookups;
    val parallelFutures = system.actorOf(Props[ParallelFutures], "ParallelFutures")
    val parallelFuturesWithZip = system.actorOf(Props[ParallelFuturesWithZip], "ParallelFuturesWithZip")
    val sequentialFutures = system.actorOf(Props[SequentialFutures], "SequentialFutures")
    parallelFutures ! new GetPricingInfo(new User {})
    parallelFuturesWithZip ! new GetPricingInfo(new User {})
    sequentialFutures ! new GetPricingInfo(new User {})
    //    system.terminate()
  }
}

class ParallelFutures extends Actor {

  implicit val ec: ExecutionContext = context.dispatcher

  def receive = {
    case GetPricingInfo(user: User) =>

      val f1 = Future {
        Thread.sleep(5000)
        println("parallel f1")
      }
      val f2 = Future {
        Thread.sleep(1000)
        println("parallel f2")
      }
      val response = for {
        m1 <- f1
        m2 <- f2
      } yield (m1, m2)
      response map println
  }
}

class ParallelFuturesWithZip() extends Actor {
  implicit val ec: ExecutionContext = context.dispatcher
  def receive = {
    case GetPricingInfo(user: User) =>
      val response = for {
        (f1, f2) <- Future {
          Thread.sleep(5000)
          println("parallel zip f1")
        } zip Future {
          Thread.sleep(1000)
          println("parallel zip f2")
        }
      } yield (f1, f2)
      response map println
  }
}


class SequentialFutures() extends Actor {
  implicit val ec: ExecutionContext = context.dispatcher

  def receive = {
    case GetPricingInfo(user: User) =>
      val response = for {
        f1 <- Future {
          Thread.sleep(5000)
          println("sequential f1, this will print first, even if it takes longer")
        }
        f2 <- Future {
          Thread.sleep(1000)
          println("sequential f2, this will print second")
        }
      } yield (f1, f2)
      response map println
  }
}


trait User {

  val id: Int = 123
}

case class GetPricingInfo(user: User)


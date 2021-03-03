package com.marmoush.scalasamples.akka_concurrency.flight

import akka.actor.{Actor, Props}
import MyActor.{Ping, Pong}
import org.scalatest.{MustMatchers, ParallelTestExecution, WordSpec}

object MyActor {

  case object Ping

  case object Pong

}

class MyActor extends Actor {
  override def receive: Receive = {
    case Ping => sender ! Pong
  }
}

class TestParallelActor extends WordSpec with MustMatchers with ParallelTestExecution {
  "My Actor" should {
    "throw when made with the wrong name" in new UniqueActorSystem {
      // an[Exception] mustBe thrownBy {
      // use a generated name
      val a = system.actorOf(Props[MyActor])
      //      }
    }
    "construct without exception" in new UniqueActorSystem {
      val a = system.actorOf(Props[MyActor], "MyActor")
      // The throw will cause the test to fail
    }
    "respond with a Pong to a Ping" in new UniqueActorSystem {
      val a = system.actorOf(Props[MyActor], "MyActor")
      a ! Ping
      expectMsg(Pong)
    }
  }
}
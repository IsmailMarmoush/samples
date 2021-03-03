package com.marmoush.scalasamples.akka_concurrency.flight

import java.util.concurrent.atomic.AtomicInteger

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}

object UniqueActorSystem {
  val uniqueId = new AtomicInteger(0)
}

class UniqueActorSystem(name: String) extends TestKit(ActorSystem(name)) with ImplicitSender with DelayedInit {
  def this() =  this("TestingActorSystem")
  // this("TestSystem%05d".format(UniqueActorSystem.uniqueId.getAndIncrement()))

  def shutdown(): Unit = system.terminate()

  def delayedInit(f: => Unit): Unit = {
    try {
      f
    } finally {
      shutdown()
    }
  }
}
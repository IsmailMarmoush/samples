package com.marmoush.scalasamples.akka_concurrency.flight

import akka.actor.Actor.Receive
import akka.actor.{Actor, ActorRef, Props, ActorSystem}
import akka.testkit.{TestKit, TestProbe}
import org.scalatest.{WordSpecLike, MustMatchers}

class TestProbes extends TestKit(ActorSystem("TestProbesSystem")) with MustMatchers with WordSpecLike{
  "The AnnoyingActor" should {
    "say Hello!!!" in {
      val p = TestProbe()
      val a = system.actorOf(Props(new AnnoyingActor(p.ref)))
      // We're expecting the message on the unique TestProbe,
      // not the general testActor that the  T provides
        p.expectMsg("Hello!!!")
      system.stop(a)
    }
  }
}

class AnnoyingActor(snooper: ActorRef) extends Actor {
  override def preStart() {
    self ! 'hi
  }
  def receive = {
    case 'hi =>
      snooper ! "Hello!!!"
      self ! 'hi
  }
}
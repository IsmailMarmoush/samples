package com.marmoush.scalasamples.akka_concurrency.flight

import akka.actor.{Actor, ActorSystem, Props}
import akka.testkit.TestKit
import org.scalatest.FlatSpecLike

class TestActorPaths extends TestKit(ActorSystem("EventSourceSpec")) with FlatSpecLike {

  val testSys = ActorSystem("TheSystem")
  val anony = testSys.actorOf(Props(new Actor {
    def receive = {
      case _ =>
    }
  }), "AnonymousActor")

  "actor.path" should "be 'akka://TheSystem/user/AnonymousActor' " in {
    assert(anony.path.toString == "akka://TheSystem/user/AnonymousActor")
  }

  "actor.path.elements" should "be '/user/AnonymousActor' " in {
    assert(anony.path.elements.mkString("/", "/", "") == "/user/AnonymousActor")
  }

  "anony.path.name" should "be 'AnonymousActor' " in {
    assert(anony.path.name == "AnonymousActor")
  }
}

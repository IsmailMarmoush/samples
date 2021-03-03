package com.marmoush.scalasamples.akka_concurrency.flight

import java.util.concurrent.{CountDownLatch, TimeUnit}

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.scalatest.{BeforeAndAfterAll, MustMatchers, WordSpecLike}

object EventSourceSpy {
  val latch = new CountDownLatch(1)
}

trait EventSourceSpy extends EventSource {
  override def sendEvent[T](event: T): Unit = EventSourceSpy.latch.countDown()

  override def eventSourceReceive = {
    case "" =>
  }
}

class AltimeterSpec extends TestKit(ActorSystem("AltimeterSpec")) with ImplicitSender with WordSpecLike with MustMatchers with BeforeAndAfterAll {

  import Altimeter._

  override def afterAll() {
    system.terminate
  }

  def slicedAltimeter = new Altimeter with EventSourceSpy

  def actor() = {
    val a = TestActorRef[Altimeter](Props(slicedAltimeter))
    (a, a.underlyingActor)
  }

  "Altimeter" should {

    "record rate of climb changes" in {
      val (_, real) = actor()
      real.receive(RateChange(1f))
      real.rateOfClimb must be(real.maxRateOfClimb)
    }

    "keep rate of climb changes within bounds" in {
      val (_, real) = actor()
      real.receive(RateChange(2f))
      real.rateOfClimb must be(real.maxRateOfClimb)
    }

    "calculate altitude changes" in {
      val ref = system.actorOf(Props(Altimeter()))
      ref ! EventSource.RegisterListener(testActor)
      ref ! RateChange(0.9f)
      fishForMessage() {
        case AltitudeUpdate(altitude) if (altitude) == 0f => false
        case AltitudeUpdate(altitude) => true
      }
    }

    "send events" in {
      val (ref, _) = actor()
      EventSourceSpy.latch.await(1, TimeUnit.SECONDS) must be(true)
    }
  }

}
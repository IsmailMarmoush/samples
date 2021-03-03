package com.marmoush.scalasamples.akka_concurrency.flight.flight_attendant

import akka.actor.{ActorSystem, Props}
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import com.marmoush.scalasamples.akka_concurrency.flight.flight_attendant.FlightAttendant.{Drink, GetDrink}
import com.marmoush.scalasamples.akka_concurrency.flight.flight_attendant.{AttendantResponsiveness, FlightAttendant}
import org.scalatest.{MustMatchers, WordSpecLike}

object TestFlightAttendant {
  def apply() = new FlightAttendant
    with AttendantResponsiveness {
    val maxResponseTimeMS = 1
  }
}

/*
import com.typesafe.config.ConfigFactory
class FlightAttendantSpec extends
TestKit(ActorSystem("FlightAttendantSpec",
  ConfigFactory.parseString(
    "akka.scheduler.tick-duration = 1ms"))
*/

class FlightAttendantSpec extends TestKit(ActorSystem("FlightAttendantSpec")) with ImplicitSender with WordSpecLike with MustMatchers {

  "FlightAttendant" should {
    "get a drink when asked" in {
      val a = TestActorRef(Props(TestFlightAttendant()))
      a ! GetDrink("Soda")
      expectMsg(Drink("Soda"))
    }
  }
}
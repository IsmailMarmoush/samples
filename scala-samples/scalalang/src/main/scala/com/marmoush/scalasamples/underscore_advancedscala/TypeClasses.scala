package com.marmoush.scalasamples.underscore_advancedscala

sealed trait Json
final case class JsObject(get: Map[String, Json]) extends Json
final case class JsString(get: String)            extends Json
final case class JsNumber(get: Double)            extends Json

// The "serialize to JSON" behavior is encoded in this trait
trait JsonWriter[A] {
  def write(value: A): Json
}

final case class Person(name: String, email: String)
final case class Car(brand: String)

object JsonWriterInstances {
  implicit val stringJsonWriter = new JsonWriter[String] {
    def write(value: String): Json = JsString(value)
  }

  implicit val personJsonWriter = new JsonWriter[Person] {
    def write(value: Person): Json = JsObject(Map("name" -> JsString(value.name), "email" -> JsString(value.email)))
  }
}

object Json {

  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)
}

object JsonSyntax {
  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit w: JsonWriter[A]): Json = w.write(value)
  }
}

object App {
  import JsonWriterInstances._
  import JsonSyntax._
  Person("Dave", "dave@example.com").toJson
  // Car("BMW").toJson will produce an exception
  def main(args: Array[String]): Unit = {
    println("hello")
  }
}

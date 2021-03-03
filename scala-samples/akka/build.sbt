name := "scala-samples"
organization := "com.marmoush"
version := "0.0.1"
scalaVersion := "2.11.7"

val akkaVersion = "2.4.0"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test")
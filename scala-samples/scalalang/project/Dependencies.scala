import sbt._

object Dependencies {
  // Logging Support
  val log4j2Version       = "2.6"
  val scalaLoggingVersion = "3.4.0"

  // Config Hocoon Support
  val typesafeConfigVersion = "1.3.0"

  // Test Support
  val scalaTestVersion = "2.2.6"

  // Metrics Support
  val scalaMetricsVersion = "3.5.4"

  lazy val catsVersion     = "1.0.1"
  lazy val akkaVersion     = "2.5.4"
  lazy val akkaHttpVersion = "10.0.10"

  val compileDeps = Seq(
    "org.typelevel"     %% "cats-core"            % catsVersion,
    "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-testkit"         % akkaVersion
  )

  val testDeps = Seq(
    "org.scalatest"  %% "scalatest"      % "3.0.1" % "test",
    "ch.qos.logback" % "logback-classic" % "1.2.3" % "test"
  )
}

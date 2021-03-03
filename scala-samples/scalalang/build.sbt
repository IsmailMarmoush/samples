lazy val root =
  project
    .in(file("."))
    .settings(name := "scalalang", description := "Scala Samples", organization := "com.marmoush", version := "0.0.2")
    .settings(MySettings.scalaSettings)
    .settings(clippyColorsEnabled := true)
    //    .settings(wartremoverWarnings ++= Warts.unsafe)
    //    .settings(wartremoverErrors ++= Warts.unsafe)
    .settings(scalacOptions ++= MySettings.scalacOptions)
    .settings(libraryDependencies ++= Dependencies.compileDeps ++ Dependencies.testDeps)

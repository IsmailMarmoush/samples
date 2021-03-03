package com.marmoush.scalasamples.samples

import java.io.File

object Chp09 {

  def main(args: Array[String]) {
    val filesHere = Array("hi", "hi", "k")
    val forLineLengths =
      for {
        file    <- filesHere
        trimmed = file + "kk"

      } yield trimmed.length
    forLineLengths.foreach(println)
    /* for (fl <- forLineLengths)
      println(fl) */
    println(filesEnding("emacs").foreach(println))
  }

  def filesEnding(query: String): Array[File] =
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file

  private def filesHere = (new java.io.File(".")).listFiles

}

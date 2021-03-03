package com.marmoush.scalasamples.samples

import scala.io.Source

object ReadFromFile {

  def readFromFiles(args: Array[String]) =
    if (args.length > 0) {
      for (line <- Source.fromFile(args(0)).getLines())
        println(line.length + " " + line)
    } else
      Console.err.println("Please enter filename")
}

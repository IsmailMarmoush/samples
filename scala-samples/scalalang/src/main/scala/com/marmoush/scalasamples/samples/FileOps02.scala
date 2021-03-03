package com.marmoush.scalasamples.samples

import java.io.{File, PrintWriter}

object NewControls {

  def main(args: Array[String]): Unit = {
    // file is no longer part of scala STDLIB
    val k      = withPrintWriter(new File("date.txt"), writer => writer.println(new java.util.Date))
    val source = scala.io.Source.fromFile("date.txt")
    val lines  = source.mkString
    lines.foreach(println)
    source.close()
  }

  def withPrintWriter(file: File, op: PrintWriter => Unit) = {
    val writer = new PrintWriter(file)
    try {
      op(writer)
    } finally {
      writer.close()
    }
  }

  def endsWithScala(filesHere: List[File]) = {
    for (file <- filesHere if file.isFile
         if file.getName.endsWith(".scala")) println(file)

    def fileLines(file: java.io.File) =
      scala.io.Source.fromFile(file).getLines().toList

    def grep(pattern: String) =
      for (file <- filesHere if file.getName.endsWith(".scala");
           line <- fileLines(file) if line.trim.matches(pattern))
        println(file + ": " + line.trim)
    grep(".*gcd.*")

    def grep2(pattern: String) =
      for {
        file    <- filesHere if file.getName.endsWith(".scala")
        line    <- fileLines(file)
        trimmed = line.trim
        if trimmed.matches(pattern)
      } println(file + ": " + trimmed)
    grep(".*gcd.*")

    val forLineLengths =
      for {
        file <- filesHere
        if file.getName.endsWith(".scala")
        line    <- fileLines(file)
        trimmed = line.trim
        if trimmed.matches(".*for.*")
      } yield trimmed.length
  }
}

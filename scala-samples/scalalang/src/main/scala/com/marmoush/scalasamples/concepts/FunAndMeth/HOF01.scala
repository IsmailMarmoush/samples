package com.marmoush.scalasamples.concepts.FunAndMeth

object HOFs {

  def main(args: Array[String]): Unit = {
    (new FileMatch01).filesEnding("")
    (new FileMatch02).filesRegex("e")
  }
}

class FileMatch01 {
  def filesEnding(query: String) = filesMatching(query, _.endsWith(_))

  def filesMatching(query: String, matcher: (String, String) => Boolean) =
    for (file <- filesHere; if matcher(file.getName, query))
      yield file

  private def filesHere = (new java.io.File(".")).listFiles

  def filesContaining(query: String) = filesMatching(query, _.contains(_))

  def filesRegex(query: String) = filesMatching(query, _.matches(_))

}

class FileMatch02 {
  def filesEnding(query: String) = filesMatching(_.endsWith(query))

  private def filesMatching(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  private def filesHere = (new java.io.File(".")).listFiles

  def filesContaining(query: String) = filesMatching(_.contains(query))

  def filesRegex(query: String) = filesMatching(_.matches(query))
}

package com.marmoush.scalasamples.concepts

object Implicits {

  import java.text.SimpleDateFormat

  implicit def strToDate(str: String) =
    new SimpleDateFormat("yyyy-MM-dd").parse(str) //> strToDate: (str: String)java.util.Date

  println("2013-01-01 unix time: " + "2013-01-01".getTime() / 1000l)
  //> 2013-01-01 unix time: 1357016400

}
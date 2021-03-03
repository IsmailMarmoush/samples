package com.marmoush.scalasamples.samples

object Importing {
  // import Fruits.{ Apple, Orange }
  // 4- Rename
  //  import Fruits.{ Apple => McIntosh, Orange }
  //  import all and rename
  //  import Fruits.{ Apple => McIntosh, _ }
  // 5- Exclusion
  //  import Fruits.{ Pear => _, _ }

  // everything in the java.lang package
  import scala._

  // everything in the scala package
  import Predef._

  // everything in the Predef object
}

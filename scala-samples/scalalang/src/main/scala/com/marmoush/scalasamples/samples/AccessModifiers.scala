package com.marmoush.scalasamples.samples

package bobsrockets {

  package navigation {

    private[bobsrockets] class Navigator {
      // even if the following appeared in the class itself
      val other = new Navigator
      // other.speed // this line would not compile
      private[this] var speed = 200

      protected[navigation] def useStarChart() {}

      class LegOfJourney {
        private[Navigator] val distance = 100
      }
    }

  }

  package launch {

    import com.marmoush.scalasamples.samples.bobsrockets.navigation._

    object Vehicle {
      private[launch] val guide = new Navigator
    }

  }

}

object AccessModifiers {
  //* no access modifier
  //	* public access
  //* private[bobsrockets]
  //	* access within outer package
  //* private[navigation]
  //	* same as package visibility in Java
  //* private[Navigator]
  //	* same as private in Java
  //* private[LegOfJourney]
  //	* same as private in Scala
  //* private[this]
  //	* access only from same object

}

package com.marmoush.scalasamples.design_patterns

/**
  * http://stackoverflow.com/questions/8073263/explicit-self-references-with-no-type-difference-with-this
  */
class SelfConventionForInnerClasses {

  /** ************************* Question *****************/
  //
  //  trait T {
  //    self : T2 =>
  //    ...
  //  }
  //  In the body, self is an alias for this but has the more precise type T with T2.
  //
  //    Now, I've seen this in code:
  //
  //  trait T {
  //    self =>
  //    ...
  //  }

  /** ****** Answer ************************/
  //  It is an alias for this.
  //
  //    Your first example is useful for ensuring that the trait has been mixed in to an appropriate type, and makes those methods available.
  //
  //    The second example is useful when you have inner classes with naming conflicts, to make the outer scope visible. For example:

  trait U {
    self =>
    val name = "outer"

    val b = new AnyRef {
      val name = "inner"
      println(name)
      println(this.name)
      println(self.name)
    }
  }

  //  Then new AnyRef with U prints
  //
  //  inner
  //  inner
  //  outer

  //  "self" is not a special keyword - you can use "bananas =>" or whatever you like, but it's often used by convention.
}

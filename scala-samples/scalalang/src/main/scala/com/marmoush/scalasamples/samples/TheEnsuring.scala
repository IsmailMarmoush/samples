package com.marmoush.scalasamples.samples

object TheEnsuring {
  // http://stackoverflow.com/questions/5843791/why-does-ensuring-work-only-on-else

  def evenIt(x: Int) = {
    if (x % 2 == 0)
      x + 1 //return odd on purpose!
    else
      x + 1
  } ensuring (_ % 2 == 0)
}

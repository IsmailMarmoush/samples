package com.marmoush.scalasamples.concepts.types

object compoundTypes {

  val k = new Mix(3) //> k  : com.marmoush.scalasamples.concepts.types.compoundTypes.Mix = com.marmou

  def cloneAndReset(obj: Cloneable with Resetable) = {
    obj.reset
  }

  trait Cloneable extends java.lang.Cloneable {
    override def clone(): Cloneable = {
      super.clone(); this
    }
  }

  //> cloneAndReset: (obj: com.marmoush.scalasamples.concepts.types.compoundTypes.
  //| Cloneable with com.marmoush.scalasamples.concepts.types.compoundTypes.Reseta
  //| ble)Unit

  trait Resetable {
    def reset: Unit
  }

  class Mix(var x: Int) extends Cloneable with Resetable {
    override def reset(): Unit = {
      x = 0
    }
  }
  //| sh.scalasamples.concepts.types.compoundTypes$$anonfun$main$1$Mix$1@74b1896c
  println(k.x) //> 3
  cloneAndReset(k)
  println(k.x) //> 0
}
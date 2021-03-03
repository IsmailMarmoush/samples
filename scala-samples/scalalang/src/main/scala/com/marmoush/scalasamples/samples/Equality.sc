package com.marmoush.scalasamples.samples

object Equality {

  // > The == is used in value types as equals but There are situations where you need reference equality instead of user-defined equality. For example, in some situations where efficiency is paramount, you would like to hash cons with some classes and compare their instances with reference equality. You hash cons instances of a class by caching all instances you have created in a weak collection. Then, any time you want a new instance of the class, you first check the cache. If the cache already has an element equal to the one you are about to create, you can reuse the existing instance. As a result of this arrangement, any two instances that are equal with equals() are also equal with reference equality.

  // > For these cases, class AnyRef defines an additional eq method, which cannot be overridden and is implemented as reference equality (i.e., it behaves like == in Java for reference types). There’s also the negation of eq, which is called ne.

  val x = new String("abc")
  //> x  : String = abc
  val y = new String("abc") //> y  : String = abc
  x == y //> res0: Boolean = true
  x eq y //> res1: Boolean = false
  x ne y //> res2: Boolean = true
}
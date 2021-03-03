package com.marmoush.scalasamples.samples

object BottomTypes {

  // ## Bottom Types (Null, Nothing)
  // Null is subtype of AnyRef so you can't assign it to Value Types

  // val i: Int = null

  // Nothing is  subtype of every other type

  //> error: (message: String)Nothing
  // because it's subtype of Int you can do the following
  def divide(x: Int, y: Int): Int =
    if (y != 0) x / y
    else error("can't divide by zero") //> divide: (x: Int, y: Int)Int

  def error(message: String): Nothing =
    throw new RuntimeException(message)

}
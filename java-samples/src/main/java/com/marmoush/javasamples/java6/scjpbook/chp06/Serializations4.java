package com.marmoush.javasamples.java6.scjpbook.chp06;

public class Serializations4 {
  /*
   * If you are a serializable class, but your superclass is NOT serializable,
   * then any instance variables you INHERIT from that superclass will be
   * reset to the values they were given during the original construction of
   * the object. This is because the non-serializable class constructor WILL
   * run!
   *
   * In fact, every constructor ABOVE the first non-serializable class
   * constructor will also run, no matter what, because once the first super
   * constructor is invoked, (during deserialization), it of course invokes
   * its super constructor and so on up the inheritance tree.
   */
}

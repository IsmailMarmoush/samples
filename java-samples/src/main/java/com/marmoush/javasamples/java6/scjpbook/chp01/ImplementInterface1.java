package com.marmoush.javasamples.java6.scjpbook.chp01;

public class ImplementInterface1 implements Interface1 {
  /**
   * You could remove throws ExceptionParent
   *
   * <p>You could replace it with ExceptionChild
   *
   * <p>But if it was ExceptionChild you can't replace it with ExceptionParent
   */
  @Override
  public void sayHi() throws ExceptionParent {}
}

package com.marmoush.javasamples.designpatternsgof.structural.bridge2;

/** Concrete implementation 2 for bridge pattern */
public class Assemble implements Workshop {

  @Override
  public void work() {
    System.out.println(" Assembled.");
  }
}

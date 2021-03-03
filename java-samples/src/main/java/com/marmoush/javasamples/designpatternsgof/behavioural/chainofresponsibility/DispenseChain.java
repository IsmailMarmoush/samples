package com.marmoush.javasamples.designpatternsgof.behavioural.chainofresponsibility;

public interface DispenseChain {

  void setNextChain(DispenseChain nextChain);

  void dispense(Currency cur);
}

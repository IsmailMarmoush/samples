package com.marmoush.javasamples.annotations;

public class AnnotationRunner {

  public void method1() {
    System.out.println("method1");
  }

  @CanRun
  public void method2() {
    System.out.println("method2");
  }

  @CanRun
  public void method3() {
    System.out.println("method3");
  }

  public void method4() {
    System.out.println("method4");
  }

  public void method5() {
    System.out.println("method5");
  }
}

package com.marmoush.javasamples.designpatternsgof.behavioural.templatemethod;

abstract class Generalization {
  // 1. Standardize the skeleton of an algorithm in a "template" method
  public void findSolution() {
    stepOne();
    stepTwo();
    stepThr();
    stepFor();
  }

  // 2. Common implementations of individual steps are defined in base class
  protected void stepOne() {
    System.out.println("Generalization.stepOne");
  }

  // 3. Steps requiring peculiar impls are ";placeholders" in the base class
  protected abstract void stepTwo();

  protected abstract void stepThr();

  protected void stepFor() {
    System.out.println("Generalization.stepFor");
  }
}

abstract class Specialization extends Generalization {
  // 4. Derived classes can override placeholder methods
  // 1. Standardize the skeleton of an algorithm in a "template" method
  protected void stepThr() {
    step3_1();
    step3_2();
    step3_3();
  }

  // 2. Common implementations of individual steps are defined in base class
  protected void step3_1() {
    System.out.println("Specialization.step3_1");
  }

  // 3. Steps requiring peculiar impls are "placeholders" in the base class
  protected abstract void step3_2();

  protected void step3_3() {
    System.out.println("Specialization.step3_3");
  }
}

class Realization extends Specialization {
  // 4. Derived classes can override placeholder methods
  protected void stepTwo() {
    System.out.println("Realization   .stepTwo");
  }

  // 5. Derived classes can override implemented methods
  // 6. Derived classes can override and "call back to" base class methods
  protected void stepFor() {
    System.out.println("Realization   .stepFor");
    super.stepFor();
  }

  protected void step3_2() {
    System.out.println("Realization   .step3_2");
  }
}

class TemplateMethodDemo {
  public static void main(String[] args) {
    Generalization algorithm = new Realization();
    algorithm.findSolution();
  }
}

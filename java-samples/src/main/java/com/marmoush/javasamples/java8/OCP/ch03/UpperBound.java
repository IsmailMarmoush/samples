package com.marmoush.javasamples.java8.OCP.ch03;

import java.util.List;

public class UpperBound {
  <T extends Mammal> T method3(List<T> list) {
    /* <T extends Mammal> says that you want to use T as a type
    parameter just for this method and that it needs to extend the Mammal class */
    T t = list.get(0);
    return t;
    //    return list.get(0);
  }
}

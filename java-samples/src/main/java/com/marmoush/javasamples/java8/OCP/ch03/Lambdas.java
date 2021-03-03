package com.marmoush.javasamples.java8.OCP.ch03;

import java.util.Arrays;
import java.util.List;

public class Lambdas {
  public static void main(String[] args) {
    List<String> cats = Arrays.asList("Annie", "Ripley");
    for (String cat : cats)
      System.out.println(cat);
    //    cats.forEach();
  }
}

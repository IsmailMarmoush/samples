package com.marmoush.javasamples.java8.Other;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class LambdaExpression {
  public static void main(String[] args) {}

  public void callable() throws Exception {
    Callable<Double> pi = () -> 3.14;
    Double p = pi.call();
  }

  public void sorting() {
    String[] words = {"aaa", "b", "cc"};

    Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
    // equivalent to:
    Arrays.sort(words, (String s1, String s2) -> s1.length() - s2.length());
  }

  public void runnables() {
    // s is effectively final (not changed anywhere)
    String s = "foo";
    // s can be referenced in the lambda
    Runnable r = () -> System.out.println(s);
  }
}

package com.marmoush.javasamples.java8.OCP.ch07;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Streaming {
  public static void main(String[] args) {
    System.out.println(IntStream.iterate(1, i -> 1).limit(100).sum());
    System.out.println(Arrays.asList("duck", "chicken", "flamingo", "pelican", "hi")
                             .parallelStream()
                             .parallel()
                             .reduce(0, (c1, c2) -> c1 + c2.length(), (s1, s2) -> s1 + s2));
  }
}

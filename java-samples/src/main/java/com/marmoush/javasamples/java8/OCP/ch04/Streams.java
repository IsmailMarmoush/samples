package com.marmoush.javasamples.java8.OCP.ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams {
  public static void main(String[] args) {
    // Finite streams
    List<Integer> l = Arrays.asList(1, 2, 3, 4);
    Stream<Integer> s = l.stream();

    Stream<Integer> ps = l.parallelStream();
    System.out.println(s.reduce((a, b) -> a + b));
    // System.out.println(s.reduce((a, b) -> a + b)); // Exception already closed
    System.out.println(ps.reduce((a, b) -> a + b));

    // Infinite stream
    Stream<Integer> odds = Stream.iterate(1, n -> n + 1);
    //    System.out.println(odds.min(Integer::compareTo));  // Never terminates
    odds.filter(i -> i / 5 > 10 && i / 3 < 100).forEach(System.out::println);

  }
}

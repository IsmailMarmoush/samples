package com.marmoush.javasamples.algorithms;

import io.vavr.collection.Stream;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Powerset {
  @Test
  public void generatePowerset() {
    Integer[] integers = Stream.range(0, 5).toJavaArray(Integer[]::new);

    //    long start = System.nanoTime();
    System.out.println(powerset(integers));
    //    long finish = System.nanoTime();
    //    System.out.println(finish - start);
    //    start = System.nanoTime();
    //    powersetBinary(integers);
    //    powersetBinaryStream(integers);
    //    finish = System.nanoTime();
    //    System.out.println(finish - start);
  }

  public static <T> Set<Set<T>> powerset(T[] arr) {
    Set<Set<T>> result = new HashSet<>();
    for (T t : arr) {
      Set<Set<T>> temp = new HashSet<>();
      // get sets that are already in result
      for (Set<T> a : result) {
        temp.add(new HashSet<>(a));
      }
      // add S[i] to existing sets
      for (Set<T> a : temp) {
        a.add(t);
      }
      // add S[i] only as a set
      Set<T> single = new HashSet<>();
      single.add(t);
      temp.add(single);
      result.addAll(temp);
    }
    result.add(Set.of());
    return result;
  }

  public static <T> Stream<Set<T>> powersetBinaryStream(T[] s) {
    double length = Math.pow(2, s.length);
    return Stream.range(0, (int) length).map(i -> mask(s, i));
  }

  public static <T> Set<Set<T>> powersetBinary(T[] s) {
    Set<Set<T>> result = new HashSet<>();
    double length = Math.pow(2, s.length);
    for (int i = 0; i < length; i++) {
      result.add(mask(s, i));
    }
    return result;
  }

  private static <T> Set<T> mask(T[] c, int input) {
    Set<T> chars = new HashSet<>();
    for (int i = 0; i < c.length; i++) {
      if ((input & (1 << i)) != 0)
        chars.add(c[i]);
    }
    return chars;
  }
}

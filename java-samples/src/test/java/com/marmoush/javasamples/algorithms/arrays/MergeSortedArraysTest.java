package com.marmoush.javasamples.algorithms.arrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class MergeSortedArraysTest {
  @Test
  public void mergeTwoArrays() {
    Integer[] x = {1, 2, 3, 4, 7, 8, 9, 12};
    Integer[] y = {0, 4, 6, 7, 20};
    System.out.println(Arrays.toString(mergeByTree(x, y)));
    System.out.println(Arrays.toString(mergeByList(x, y)));
  }
  // log(n)
  public static Integer[] mergeByList(Integer[] x, Integer[] y) {
    LinkedList<Integer> list = new LinkedList<>();
    int xi = 0, yi = 0, i = 0;
    while (xi < x.length && yi < y.length) {
      if (x[xi].equals(y[yi])) {
        list.add(x[xi++]);
        yi++;
        continue;
      }
      if (x[xi] < y[yi])
        list.add(x[xi++]);
      else
        list.add(y[yi++]);
    }
    while (xi < x.length)
      list.add(x[xi++]);

    while (yi < y.length)
      list.add(y[yi++]);
    return list.toArray(new Integer[0]);
  }

  // log(n)
  public Integer[] mergeByTree(Integer[] x, Integer[] y) {
    TreeSet<Integer> set = new TreeSet<>();
    set.addAll(Arrays.asList(x));
    set.addAll(Arrays.asList(y));
    return set.toArray(new Integer[]{});
  }
}

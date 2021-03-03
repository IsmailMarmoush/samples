package com.marmoush.javasamples.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

  int[] arr = null;

  @BeforeEach
  public void before() {
    int[] myarr = {2, 34, 2, 3, 4, 6, 2, 1, 34, 6, 66, 3, 34, 2, 323, 5, 6, 72, 34, 2, 3, 4, 6, 2, 1, 34, 6, 66, 3, 34,
                   2, 323, 5, 6, 72, 34, 2, 3, 4, 6, 2, 1, 34, 6, 66, 3, 34, 2, 323, 5, 6, 73, 34, 2, 323, 5, 6, 72, 34,
                   2, 3, 4, 6, 2, 1, 34, 6, 66, 3, 34, 2, 323, 5, 6, 73, 34, 2, 323, 5, 6, 72, 34, 2, 3, 4, 6, 2, 1, 34,
                   6, 66, 3, 34, 2, 323, 5, 6, 73, 34, 2, 323, 5, 6, 72, 34, 2, 3, 4, 6, 2, 1, 34, 6, 66, 3, 34, 2, 323,
                   5, 6, 73, 34, 2, 323, 5, 6, 72, 34, 2, 3, 4, 6, 2, 1, 34, 6, 66, 3, 34, 2, 323, 5, 6, 73, 34, 2, 323,
                   5, 6, 72, 34, 2, 3, 4, 6, 2, 1, 34, 6, 66, 3, 34, 2, 323, 5, 6, 73, 34, 2, 323, 5, 6, 72, 34, 2, 3,
                   4, 6, 2, 1, 34, 6, 66, 3, 34, 2, 323, 5, 6, 7};
    this.arr = myarr;
    System.out.println("Resetting Array");
  }

  @Test
  public void bubbleSort1() {
    BubbleSort.bubbleSort1(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  @Test
  public void bubbleSort2() {
    BubbleSort.bubbleSort2(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  @Test
  public void bubbleSort3() {
    BubbleSort.bubbleSort3(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}

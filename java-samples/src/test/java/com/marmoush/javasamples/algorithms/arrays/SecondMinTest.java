package com.marmoush.javasamples.algorithms.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SecondMinTest {
  @Test
  public void findSecondMinimum() {
    int[] arr = {4, 2, 3, 5, 1, 8,};
    System.out.println(findSecondMin(arr));
  }

  public static int findSecondMin(int[] arr) {
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < min1) {
        min2 = min1;
        min1 = arr[i];
      } else
        if (arr[i] < min2)
          min2 = arr[i];
    }
    //    for (int i = 0; i < arr[0]; i++) {
    //      if (arr[i] < min2 && arr[i] > min1)
    //        min2 = arr[i];
    //    }
    return min2;
  }
}

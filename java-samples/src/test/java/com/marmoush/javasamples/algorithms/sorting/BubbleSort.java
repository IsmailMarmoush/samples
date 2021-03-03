package com.marmoush.javasamples.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    int[] arr = {2, 3, 5, 6, 2, 1};
    bubbleSort1(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void bubbleSort1(int array[]) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

  /* with most right element ignored */
  public static void bubbleSort2(int array[]) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - (1 + i); j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
  }

  /* with most right element ignored, and With noswaps check */
  public static void bubbleSort3(int array[]) {
    for (int i = 0; i < array.length; i++) {
      boolean noSwaps = true;
      for (int j = 0; j < array.length - (1 + i); j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          noSwaps = false;
        }
      }
      if (noSwaps) {
        break;
      }
    }
  }
}

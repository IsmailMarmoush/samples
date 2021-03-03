package com.marmoush.javasamples.algorithms.sorting;

import java.util.Arrays;

/** @author Ismail Marmoush */
public class InsertionSort {
  public static void main(String[] args) {
    int[] arr = {2, 3, 5, 6, 2, 1};
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int j = i;
      while (j > 0 && arr[j - 1] > arr[j]) {
        int tmp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = tmp;
        j--;
      }
    }
  }
}

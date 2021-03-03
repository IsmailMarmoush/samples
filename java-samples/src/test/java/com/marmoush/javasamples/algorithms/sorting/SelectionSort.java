package com.marmoush.javasamples.algorithms.sorting;

public class SelectionSort {
  public static void selectionSort2(int[] num) {
    int first, temp;
    for (int i = num.length - 1; i > 0; i--) {
      first = 0;
      for (int j = 1; j <= i; j++) {
        if (num[j] < num[first]) {
          first = j;
          System.out.print(first);
        }
      }
      temp = num[first];
      num[first] = num[i];
      num[i] = temp;
    }
  }

  public void selectionSort1(int[] arr) {
    int minIndex, tmp;
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      minIndex = i;
      for (int j = i + 1; j < n; j++)
        if (arr[j] < arr[minIndex])
          minIndex = j;
      if (minIndex != i) {
        tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
      }
    }
  }
}

package com.marmoush.javasamples.algorithms.sorting;

import java.util.Arrays;

public class HeapSort2 {
  public static void main(String[] args) {
    testHeap();
  }

  public static void testHeap() {
    int[] a = {6, 5, 3, 1, 8, 7, 2, 4};
    for (int i = a.length / 2; i >= 0; i--) {
      siftDown(a, i);
      System.out.println(Arrays.toString(a));
    }
  }

  public static void siftDown(int arr[], int i) {
    int n = arr.length;
    if (2 * i >= n)
      return;
    int k = 2 * i;
    if (2 * i + 1 <= n && arr[2 * i] <= arr[2 * i + 1])
      k++;
    if (arr[i] < arr[k]) {
      swap(arr, i, k);
      siftDown(arr, k);
    }
  }

  public static void swap(int arr[], int i, int k) {
    int tmp = arr[i];
    arr[i] = arr[k];
    arr[k] = tmp;
  }
}

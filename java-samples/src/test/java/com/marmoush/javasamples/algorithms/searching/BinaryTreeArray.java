package com.marmoush.javasamples.algorithms.searching;

public class BinaryTreeArray {
  private BinaryTreeArray() {}

  public static int getLeftChild(int n, int[] arr) {
    return arr[2 * n + 1];
  }

  public static int getRightChild(int n, int[] arr) {
    return arr[2 * n + 2];
  }

  public static int getParent(int n, int[] arr) {
    return arr[(n - 1) / 2];
  }
}

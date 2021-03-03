package com.marmoush.javasamples.algorithms.crackingcodeinterview;

public class BinaryHeap {
  private final int[] arr;

  public BinaryHeap(int[] arr) {
    this.arr = arr;
  }

  /*
   * Returns the parent node
   */
  public int parent(int i) {
    return arr[(i - 1) / 2];
  }

  /*
   * Returns the left child node
   */
  public int leftChild(int i) {
    return arr[(2 * i) + 1];
  }

  /*
   * Returns the  right child  node
   */
  public int rightChild(int i) {
    return arr[(2 * i) + 2];
  }
}

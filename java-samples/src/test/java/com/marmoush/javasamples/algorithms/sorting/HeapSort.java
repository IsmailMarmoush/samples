package com.marmoush.javasamples.algorithms.sorting;

import java.util.Arrays;

/*
 * http://www.java-tips.org/java-se-tips/java.lang/heap-sort-implementation-in-java.html
 *
 * <p>http://codereview.stackexchange.com/questions/32606/implementation-of-heap-sort
 */
public class HeapSort {
  public static void main(String[] args) {
    testHeap();
    System.out.println("--------------------");
    // testHeapSort();
  }

  public static void testHeap() {
    Integer[] a = {6, 5, 3, 1, 8, 7, 2, 4};
    for (int i = a.length / 2; i >= 0; i--) {
      siftDown(a, i, a.length);
      System.out.println(Arrays.toString(a));
    }
  }

  /*
   * Internal method for heapsort that is used in deleteMax and buildHeap.
   *
   * @param a     an array of Comparable items.
   * @param index i the position from which to percolate down.
   * @param int   n the logical size of the binary heap.
   */
  private static <T extends Comparable<? super T>> void siftDown(T[] a, int i, int n) {
    int lftChldIdx;
    T tmp;

    for (tmp = a[i]; leftChildIndex(i) < n; i = lftChldIdx) {
      lftChldIdx = leftChildIndex(i);
      if (lftChldIdx != n - 1 && a[lftChldIdx].compareTo(a[lftChldIdx + 1]) < 0)
        lftChldIdx++;
      if (tmp.compareTo(a[lftChldIdx]) < 0)
        a[i] = a[lftChldIdx];
      else
        break;
    }
    a[i] = tmp;
  }

  /*
   * Internal method for heapsort.
   *
   * @param i the index of an item in the heap.
   * @return the index of the left child.
   */
  private static int leftChildIndex(int i) {
    return 2 * i + 1;
  }

  public static void testHeapSort() {
    Integer[] a = {6, 5, 3, 1, 8, 7, 2, 4};
    heapSort(a);
    System.out.println(Arrays.toString(a));
  }

  /*
   * Standard heapsort.
   *
   * @param a an array of Comparable items.
   */
  public static <T extends Comparable<? super T>> void heapSort(T[] a) {
    for (int i = a.length / 2; i >= 0; i--)
      siftDown(a, i, a.length); // build heap
    for (int i = a.length - 1; i > 0; i--) {
      swapReferences(a, 0, i); // deleteMax
      siftDown(a, 0, i);
    }
  }

  /*
   * Method to swap to elements in an array.
   *
   * @param a      an array of objects.
   * @param index1 the index of the first object.
   * @param index2 the index of the second object.
   */
  public static final void swapReferences(Object[] a, int index1, int index2) {
    Object tmp = a[index1];
    a[index1] = a[index2];
    a[index2] = tmp;
  }
}

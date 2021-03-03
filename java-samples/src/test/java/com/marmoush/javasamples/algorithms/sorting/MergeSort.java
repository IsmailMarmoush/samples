package com.marmoush.javasamples.algorithms.sorting;

import java.util.Arrays;

/**
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Sorting%20Algorithms/code/ MergeSort.java
 *
 * <p>http://stackoverflow.com/questions/1735863/merge-sort-java</p>
 *
 * <pre>
 * merge(A, B):
 *   C = empty list
 *
 *   While A and B are not empty:
 *     If the first element of A is smaller than the first element of B:
 *       Remove first element of A.
 *       Add it to the end of C.
 *     Otherwise:
 *       Remove first element of B.
 *       Add it to the end of C.
 *
 *   If A or B still contains elements, add them to the end of C.
 *
 * mergeSort(A):
 *   if length of A is 1:
 *     return A
 *
 *   Split A into two lists, L and R.
 *
 *   Q = merge(mergeSort(L), mergeSort(R))
 *
 *   return Q
 * </pre>
 */
public class MergeSort {
  public static void main(String[] args) {
    Integer[] a = {2, 6, 3, 5, 1};
    Integer[] tmp = new Integer[a.length];
    mergeSort(a, tmp, 0, a.length - 1);
    System.out.println(Arrays.toString(a));
  }

  private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmp, int left, int right) {
    if (left < right) {
      int center = (left + right) / 2;
      mergeSort(a, tmp, left, center);
      mergeSort(a, tmp, center + 1, right);
      merge(a, tmp, left, center + 1, right);
    }
  }

  private static <T extends Comparable<? super T>> void merge(T[] a, T[] tmp, int left, int right, int rightEnd) {
    int leftEnd = right - 1;
    int k = left;
    int num = rightEnd - left + 1;

    while (left <= leftEnd && right <= rightEnd)
      if (a[left].compareTo(a[right]) <= 0)
        tmp[k++] = a[left++];
      else
        tmp[k++] = a[right++];

    while (left <= leftEnd)
      // Copy rest of first half
      tmp[k++] = a[left++];

    while (right <= rightEnd)
      // Copy rest of right half
      tmp[k++] = a[right++];

    // Copy tmp back
    for (int i = 0; i < num; i++, rightEnd--)
      a[rightEnd] = tmp[rightEnd];
  }
}

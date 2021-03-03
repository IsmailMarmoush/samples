package com.marmoush.javasamples.algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * http://en.wikipedia.org/wiki/Radix_sort#Example_in_Java
 *
 * <p>A sample of base 10 radix sort algorithm.
 */
public class RadixSort {
  // base 10
  // LinkedList is also a Queue
  @SuppressWarnings("unchecked")
  private static LinkedList<Integer>[] counter = new LinkedList[]{new LinkedList<Integer>(), new LinkedList<Integer>(),
                                                                  new LinkedList<Integer>(), new LinkedList<Integer>(),
                                                                  new LinkedList<Integer>(), new LinkedList<Integer>(),
                                                                  new LinkedList<Integer>(), new LinkedList<Integer>(),
                                                                  new LinkedList<Integer>(), new LinkedList<Integer>()};

  public static void main(String... args) {
    int[] test = {10, 1, 30, 156};

    // we choose 3, because we have 156 with 3 digits
    RadixSort.sortLSD(test, 3);

    System.out.println(Arrays.toString(test));
  }

  public static void sortLSD(int[] array, int maxDigitSymbols) {
    int mod = 10;
    int dev = 1;
    for (int i = 0; i < maxDigitSymbols; i++, dev *= 10, mod *= 10) {
      for (int j = 0; j < array.length; j++) {
        int bucket = (array[j] % mod) / dev;
        counter[bucket].add(array[j]);
      }
      int pos = 0;
      for (int j = 0; j < counter.length; j++) {
        Integer value = null;
        while ((value = counter[j].poll()) != null) {
          array[pos++] = value;
        }
      }
    }
  }
}

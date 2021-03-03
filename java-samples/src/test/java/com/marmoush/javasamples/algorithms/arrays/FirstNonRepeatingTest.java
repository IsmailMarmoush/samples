package com.marmoush.javasamples.algorithms.arrays;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingTest {
  @Test
  public void firstNonRepeating() {
    int[] arr = {4, 2, 3, 5, 1, 8,};
    System.out.println(firstNonRepeating(arr));
  }

  static int firstNonRepeating(int arr[]) {
    Map<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (m.containsKey(arr[i])) {
        m.put(arr[i], m.get(arr[i]) + 1);
      } else {
        m.put(arr[i], 1);
      }
    }
    for (int i = 0; i < arr.length; i++)
      if (m.get(arr[i]) == 1)
        return arr[i];
    return -1;
  }

}

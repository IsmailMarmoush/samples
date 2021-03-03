package com.marmoush.javasamples.algorithms.crackingcodeinterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Chp01Test {
  @Test
  public void uniqueStringTest() {
    Assertions.assertTrue(uniqueString("abcdefg"));
    Assertions.assertFalse(uniqueString("abca"));
  }

  public static boolean uniqueString(String str) {
    if (str.length() > 128)
      return false;
    boolean[] char_set = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (char_set[val]) {
        return false;
      }
      char_set[val] = true;
    }
    return true;
  }

  @Test
  public void permutationTest() {
    Assertions.assertTrue(permutation("hello", "olleh"));
    Assertions.assertFalse(permutation("helloo", "helooo"));
  }

  public static boolean permutation(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] letters = new int[128];
    for (char c : s.toCharArray()) {
      letters[c]++;
    }
    for (char c : t.toCharArray()) {
      if (--letters[c] < 0) {
        return false;
      }
    }
    return true;
  }
}

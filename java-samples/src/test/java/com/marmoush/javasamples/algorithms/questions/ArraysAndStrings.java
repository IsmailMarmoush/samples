package com.marmoush.javasamples.algorithms.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysAndStrings {

  /*
   * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data
   * structures?
   */
  public static boolean isUniqueChars2(String str) {
    boolean[] char_set = new boolean[256];
    for (int i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (char_set[val])
        return false;
      char_set[val] = true;
    }
    return true;
  }

  /* Write a method to decide if two strings are anagrams or not. */
  public static boolean anagram(char[] s, char[] t) {
    if (s.length != t.length)
      return false;
    Arrays.sort(s);
    Arrays.sort(t);
    for (int i = 0; i < s.length; i++) {
      if (s[i] != t[i])
        return false;
    }
    return true;
  }

  /* Write a method to decide if two strings are anagrams or not. */
  public static boolean anagram2(char[] s, char[] t) {
    if (s.length != t.length)
      return false;
    Map<Character, Integer> ms = counter(s);
    Map<Character, Integer> mt = counter(t);
    for (Map.Entry<Character, Integer> en : ms.entrySet()) {
      Integer msCount = en.getValue();
      Integer mtCount = mt.get(en.getKey());
      if (msCount != mtCount)
        return false;
    }
    return true;
  }

  private static Map<Character, Integer> counter(char[] strArr) {
    Integer msv = 0;
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < strArr.length; i++) {
      msv = map.get(strArr[i]);
      if (msv == null)
        msv = 0;
      if (msv == null)
        map.put(strArr[i], 0);
      else
        map.put(strArr[i], msv++);
    }
    return map;
  }

  /*
   * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and
   * s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a
   * rotation of “erbottlewat")
   */
  public static boolean isRotation(String s1, String s2) {
    int len = s1.length();
    // check that s1 and s2 are equal length and not empty
    if (len == s2.length() && len > 0) {
      // concatenate s1 and s1 within new buffer
      String s1s1 = s1 + s1;
      return s1s1.contains(s2);
    }
    return false;
  }

  private static boolean isSubstring(String s1s1, String s2) {
    return false;
  }
}

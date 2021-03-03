package com.marmoush.javasamples.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemSolvingCert {
  public static void main(String[] args) {
    System.out.println(longestSubarray(Arrays.asList(0, 1, 2, 1, 2, 3)));
    System.out.println(longestSubarray(Arrays.asList(1, 1, 1, 3, 3, 2, 2)));
    System.out.println(longestSubarray(Arrays.asList(1, 1, 2, 1, 4, 3, 3, 1, 2, 2, 2, 2)));
  }

  public static int longestSubarray(List<Integer> l) {
    int max = 0;
    Set<Integer> types = new HashSet<>();
    List<Integer> sub = new ArrayList<>();
    sub.add(l.get(0));
    types.add(l.get(0));
    for (int i = 1; i < l.size(); i++) {
      Integer curr = l.get(i);
      Integer prev = l.get(i - 1);
      boolean near = Math.abs(curr - prev) <= 1;
      boolean sameGroup = types.contains(curr);
      boolean spaceAvailable = types.size() < 2;
      if (near && (sameGroup || spaceAvailable)) {
        sub.add(curr);
        types.add(curr);
        if (sub.size() > max)
          max = sub.size();
      } else {
        if (sub.size() > max)
          max = sub.size();
        sub.clear();
        types.clear();
        sub.add(curr);
        types.add(curr);
        if (near) {
          sub.add(prev);
          types.add(prev);
        }
      }
      //      System.out.println(sub);
      //      System.out.println(types);
      //      System.out.println("-------------------");
    }
    return max;
  }
}

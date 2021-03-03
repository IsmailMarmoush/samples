package com.marmoush.javasamples.algorithms.hackerrank.dynamicprogramming;

import java.util.Scanner;

public class MaximumSubarray {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int cases = in.nextInt();
    int m1 = 0;
    int m2 = 0;
    for (int i = 0; i < cases; i++) {
      int n = in.nextInt();
      boolean allNeg = true;
      int maxNeg = Integer.MIN_VALUE;
      int ncSum = 0;
      int cSum = 0;
      int bestCSum = 0;
      for (int j = 0; j < n; j++) {
        int e = in.nextInt();
        cSum = Math.max(e, cSum + e);
        if (cSum > bestCSum)
          bestCSum = cSum;

        if (e >= 0) {
          allNeg = false;
          ncSum += e;
        } else {
          if (e > maxNeg) {
            maxNeg = e;
          }
        }
      }
      if (allNeg) {
        m1 = maxNeg;
        m2 = maxNeg;
      } else {
        m1 = bestCSum;
        m2 = ncSum;
      }
      System.out.println(m1 + " " + m2);
    }
    in.close();
  }
}

package com.marmoush.javasamples.algorithms.hackerrank.warmup;

import java.util.Scanner;

/**
 * <pre>
 * // Sample Input
 * 3
 * 0
 * 1
 * 4
 * </pre>
 */
public class UtopianTree {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t;
    int n;

    t = in.nextInt();
    for (int i = 0; i < t; i++) {
      int s = 1; // initial State
      n = in.nextInt();
      if (n == 0) {
        System.out.println(s);
        continue;
      }
      boolean swtch = true;
      for (int j = 0; j < n; j++) {
        if (swtch) {
          s *= 2;
          swtch = false;
        } else {
          s++;
          swtch = true;
        }
      }
      System.out.println(s);
    }
    in.close();
  }
}

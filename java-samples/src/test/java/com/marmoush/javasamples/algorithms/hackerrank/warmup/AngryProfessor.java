package com.marmoush.javasamples.algorithms.hackerrank.warmup;

import java.util.Scanner;

/**
 * <pre>
 * // Sample input
 * 2
 * 4 3
 * -1 -3 4 2
 * 4 2
 * 0 -1 2 1
 * </pre>
 */
public class AngryProfessor {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t;
    int n, k;
    t = in.nextInt();
    for (int i = 0; i < t; i++) {
      n = in.nextInt();
      k = in.nextInt();
      for (int j = 0; j < n; j++) {
        int time = in.nextInt();
        if (time <= 0)
          k--;
      }
      if (k <= 0)
        System.out.println("NO");
      else
        System.out.println("YES");
    }
    in.close();
  }
}

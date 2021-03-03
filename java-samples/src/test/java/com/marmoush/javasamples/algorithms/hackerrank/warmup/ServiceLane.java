package com.marmoush.javasamples.algorithms.hackerrank.warmup;

import java.util.Scanner;

public class ServiceLane {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t;
    int n;

    t = in.nextInt();
    n = in.nextInt();
    // Service width
    int sw[] = new int[t];
    for (int i = 0; i < t; i++) {
      sw[i] = in.nextInt();
    }

    for (int i = 0; i < n; i++) {
      int s = in.nextInt();
      int e = in.nextInt();
      int min = 4;
      for (int j = s; j <= e; j++) {
        if (sw[j] < min)
          min = sw[j];
      }
      System.out.println(min);
    }
    in.close();
  }
}

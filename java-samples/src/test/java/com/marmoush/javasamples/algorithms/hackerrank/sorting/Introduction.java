package com.marmoush.javasamples.algorithms.hackerrank.sorting;

import java.util.Scanner;

public class Introduction {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int v = in.nextInt();
    int size = in.nextInt();
    for (int i = 0; i < size; i++) {
      if (in.nextInt() == v) {
        System.out.println(i);
        break;
      }
    }
    in.close();
  }
}

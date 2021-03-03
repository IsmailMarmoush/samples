package com.marmoush.javasamples.algorithms.hackerrank.sorting;

import java.util.Scanner;

public class InsertionSort01 {
  /* Tail starts here */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int[] ar = new int[s];
    for (int i = 0; i < s; i++) {
      ar[i] = in.nextInt();
    }
    insertIntoSorted(ar);
  }

  public static void insertIntoSorted(int[] ar) {
    int last = ar.length - 1;
    int n = ar[last];
    for (int i = last; i > 0; i--) {
      if (n > ar[i - 1]) {
        ar[i] = n;
        printArray(ar);
        break;
      } else {
        ar[i] = ar[i - 1];
        printArray(ar);
      }
    }
  }

  private static void printArray(int[] ar) {
    for (int n : ar) {
      System.out.print(n + " ");
    }
    System.out.println("");
  }
}

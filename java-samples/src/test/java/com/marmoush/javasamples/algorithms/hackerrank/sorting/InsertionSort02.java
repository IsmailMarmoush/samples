package com.marmoush.javasamples.algorithms.hackerrank.sorting;

import java.util.Scanner;

public class InsertionSort02 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int s = in.nextInt();
    int[] ar = new int[s];
    for (int i = 0; i < s; i++) {
      ar[i] = in.nextInt();
    }
    insertionSortPart2(ar);
  }

  public static void insertionSortPart2(int[] ar) {
    // Fill up the code for the required logic here
    // Manipulate the array as required
    // The code for Input/Output is already provided
    for (int i = 1; i < ar.length; i++) {
      int j = i;
      while (j > 0 && ar[j - 1] > ar[j]) {
        int tmp = ar[j];
        ar[j] = ar[j - 1];
        ar[j - 1] = tmp;
        j--;
      }
      printArray(ar);
    }
  }

  private static void printArray(int[] ar) {
    for (int n : ar) {
      System.out.print(n + " ");
    }
    System.out.println("");
  }
}

package com.marmoush.javasamples.algorithms.hackerrank.warmup;

import java.util.Scanner;

public class MaxXor {
  /*
   * Complete the function below.
   */

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int res;
    int _l;
    _l = Integer.parseInt(in.nextLine());

    int _r;
    _r = Integer.parseInt(in.nextLine());

    in.close();
    res = maxXor(_l, _r);
    System.out.println(res);
  }

  static int maxXor(int l, int r) {
    int[] arr = new int[(r - l) + 1];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = l + i;
    }

    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        int xor = arr[i] ^ arr[j];
        if (max < xor)
          max = xor;
      }
    }
    return max;
  }
}

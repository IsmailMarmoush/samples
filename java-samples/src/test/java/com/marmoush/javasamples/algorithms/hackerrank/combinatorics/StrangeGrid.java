package com.marmoush.javasamples.algorithms.hackerrank.combinatorics;

import java.util.Scanner;

public class StrangeGrid {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long r;
    int c;
    r = in.nextLong();
    c = in.nextInt();
    long number = 0;
    if ((r - 1l) % 2 == 0)
      number = ((r - 1) * 5) + ((c - 1) * 2);
    else
      number = ((r - 2) * 5) + 1 + ((c - 1) * 2);
    System.out.println(number);
    in.close();
  }
}

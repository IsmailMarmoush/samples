package com.marmoush.javasamples.java6.scjpbook.chp07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class comp implements Comparator<String> {
  @Override
  public int compare(String o1, String o2) {
    return o2.compareTo(o1);
  }
}

public class SelfTest {
  public static void main(String[] args) {
    Number n = 3;
    n.longValue();
    PriorityQueue<String> pq = new PriorityQueue<String>();
    pq.add("0");
    pq.add("11");
    pq.add("2");

    pq.add("1");
    System.out.println(pq.peek());

    String[] s = {"map", "pen", "marble", "key"};
    Arrays.sort(s, new comp());
    for (String s2 : s)
      System.out.print(s2 + " ");
  }
}

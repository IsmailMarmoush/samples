package com.marmoush.javasamples.java6.scjpbook.chp07.part3;

import java.util.PriorityQueue;

public class NaturalOrdering {
  public static void main(String[] args) {

    /*
     * If you remember that spaces sort before characters and that uppercase
     * letters sort before lowercase characters, you should be good to go
     * for the exam.
     */
    String[] sa = {">ff<", "> f<", ">f <", ">FF<"}; // ordered?
    PriorityQueue<String> pq3 = new PriorityQueue<String>();
    for (String s : sa)
      pq3.offer(s);
    for (String s : sa)
      System.out.print(pq3.poll() + " ");
  }
}

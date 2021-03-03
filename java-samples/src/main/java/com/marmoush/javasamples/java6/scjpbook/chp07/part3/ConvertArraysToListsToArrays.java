package com.marmoush.javasamples.java6.scjpbook.chp07.part3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertArraysToListsToArrays {
  public static void main(String[] args) {
    // Converting arrays to Lists to arrays

  }

  public void theAsListFunc() {
    /*
     * Notice that when we print the final state of the array and the List,
     * they have both been updated with each other's changes.
     */
    String[] sa = {"one", "two", "three", "four"};
    List<String> sList = Arrays.asList(sa); // make a List
    System.out.println("size " + sList.size());
    System.out.println("idx2 " + sList.get(2));
    sList.set(3, "six"); // change List
    sa[1] = "five"; // change array
    for (String s : sa)
      System.out.print(s + " ");
    System.out.println("\nsl[1] " + sList.get(1));
  }

  public void theToArrayFunc() {
    List<Integer> iL = new ArrayList<Integer>();
    for (int x = 0; x < 3; x++)
      iL.add(x);
    Object[] oa = iL.toArray(); // create an Object array
    Integer[] ia2 = new Integer[3];
    ia2 = iL.toArray(ia2); // create an Integer array
  }
}

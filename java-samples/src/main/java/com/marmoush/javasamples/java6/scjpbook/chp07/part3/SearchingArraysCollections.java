package com.marmoush.javasamples.java6.scjpbook.chp07.part3;

import java.util.Arrays;
import java.util.Comparator;

public class SearchingArraysCollections {
  public static void main(String[] args) {
    // Searching arrays and Collections
    /*
     * Searches are performed using the binarySearch() method.
     *
     * Successful searches return the int index of the element being
     * searched.
     *
     * Unsuccessful searches return an int index that represents the
     * insertion point. The insertion point is the place in the
     * collection/array where the element would be inserted to keep the
     * collection/array properly sorted. Because positive return values and
     * 0 indicate successful searches, the binarySearch() method uses
     * negative numbers to indicate insertion points. Since 0 is a valid
     * result for a successful search, the first available insertion point
     * is -1. Therefore, the actual insertion point is represented as
     * (-(insertion point) -1). For instance, if the insertion point of a
     * search is at element 2, the actual insertion point returned will be
     * -3.
     *
     * The collection/array being searched must be sorted before you can
     * search it.
     *
     * If you attempt to search an array or collection that has not already
     * been sorted, the results of the search will not be predictable.
     *
     * If the collection/array you want to search was sorted in natural
     * order, it must be searched in natural order. (Usually this is
     * accomplished by NOT sending a Comparator as an argument to the
     * binarySearch() method.)
     *
     * If the collection/array you want to search was sorted using a
     * Comparator, it must be searched using the same Comparator, which is
     * passed as the second argument to the binarySearch() method. Remember
     * that Comparators cannot be used when searching arrays of primitives.
     */
    /*
     * When solving searching and sorting questions, two big gotchas are
     *
     * 1.Searching an array or collection that hasn�t been sorted.
     *
     * 2. Using a Comparator in either the sort or the search, but not both
     */
    String[] sa = {"one", "two", "three", "four"};
    Arrays.sort(sa); // #1
    for (String s : sa)
      System.out.print(s + " ");
    System.out.println("\none = " + Arrays.binarySearch(sa, "one")); // #2
    System.out.println("now reverse sort");
    ReSortComparator rs = new ReSortComparator(); // #3
    Arrays.sort(sa, rs);
    for (String s : sa)
      System.out.print(s + " ");
    System.out.println("\none = " + Arrays.binarySearch(sa, "one")); // #4
    System.out.println("one = " + Arrays.binarySearch(sa, "one", rs)); // #5
  }

  static class ReSortComparator implements Comparator<String> { // #6
    @Override
    public int compare(String a, String b) {
      return b.compareTo(a); // #7
    }
  }
}

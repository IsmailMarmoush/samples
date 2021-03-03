package com.marmoush.javasamples.java6.scjpbook.chp07.part3;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UsingSets {
  public static void main(String[] args) {}

  public void theHashSet() {
    boolean[] ba = new boolean[5];
    Set<Object> s = new HashSet<Object>();
    ba[0] = s.add("a");
    ba[1] = s.add(42);
    ba[2] = s.add("b");
    ba[3] = s.add("a");
    ba[4] = s.add(new Object());
    for (int x = 0; x < ba.length; x++)
      System.out.print(ba[x] + " ");
    System.out.println("\n");
    for (Object o : s)
      System.out.print(o + " ");
  }

  public void theTreeSet() {
    /*
     * Produces Exception:
     *
     * The issue is that whenever you want a collection to be sorted, its
     * elements must be mutually comparable. Remember that unless otherwise
     * specified, objects of different types are not mutually comparable.
     */
    boolean[] ba = new boolean[5];
    Set<Object> s = new TreeSet<Object>();

    ba[0] = s.add("a");
    ba[1] = s.add(42);
    ba[2] = s.add("b");
    ba[3] = s.add("a");
    ba[4] = s.add(new Object());
    for (int x = 0; x < ba.length; x++)
      System.out.print(ba[x] + " ");
    System.out.println("\n");
    for (Object o : s)
      System.out.print(o + " ");
  }
}

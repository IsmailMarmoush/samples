package com.marmoush.javasamples.java6.scjpbook.chp07.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorInterface {
  /*
   * In addition, the arrays.sort() method is overloaded about a million times
   * to provide a couple of sort methods for every type of primitive. The
   * arrays.sort() methods that sort primitives always sort based on natural
   * order. Don't be fooled by an exam question that tries to sort a primitive
   * array using a Comparator. Finally, remember that the sort() methods for
   * both the Collections class and the arrays class are static methods, and
   * that they alter the objects they are sorting, instead of returning a
   * different sorted object.
   */
}

class GenreSort implements Comparator<DVDInfo> {
  @Override
  public int compare(DVDInfo one, DVDInfo two) {
    return one.getGenre().compareTo(two.getGenre());
  }
}

class TestDVD {
  ArrayList<DVDInfo> dvdlist = new ArrayList<DVDInfo>();

  public static void main(String[] args) {
    new TestDVD().go();
  }

  public void go() {
    populateList();
    System.out.println(dvdlist); // output as read from file
    Collections.sort(dvdlist);
    System.out.println(dvdlist); // output sorted by title
    GenreSort gs = new GenreSort();
    Collections.sort(dvdlist, gs);
    System.out.println(dvdlist); // output sorted by genre
  }

  public void populateList() {
    // read the file, create DVDInfo instances, and
    // populate the ArrayList dvdlist with these instances
  }
}

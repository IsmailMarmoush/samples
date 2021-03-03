package com.marmoush.javasamples.java6.scjpbook.chp07.part3;

public class ComparableInterface {
  public static void main(String[] args) {
    /*
     * It�s important to remember that when you override equals() you MUST
     * take an argument of type Object, but that when you override
     * compareTo() you should take an argument of the type you�re sorting.
     */

    /*
     * We can only implement compareTo() once in a class, so how do we go
     * about sorting our classes in an order different than what we specify
     * in our compareTo() method?
     */
  }
}

class DVDInfo implements Comparable<DVDInfo> {
  String title;
  String genre;
  String leadActor;

  DVDInfo(String t, String g, String a) {
    title = t;
    genre = g;
    leadActor = a;
  }

  @Override
  public int compareTo(DVDInfo d) {
    return title.compareTo(d.getTitle());
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  // other getters and setters

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getLeadActor() {
    return leadActor;
  }

  public void setLeadActor(String leadActor) {
    this.leadActor = leadActor;
  }

  @Override
  public String toString() {
    return title + " " + genre + " " + leadActor + "\n";
  }
}

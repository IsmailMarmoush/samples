package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class Dates {
  public static void main(String[] args) {
    // Get the current date and time.
    // Create a Date:

    DateFormat[] dfa = new DateFormat[6];
    dfa[0] = DateFormat.getInstance();
    dfa[1] = DateFormat.getDateInstance();
    dfa[2] = DateFormat.getDateInstance(DateFormat.SHORT);
    dfa[3] = DateFormat.getDateInstance(DateFormat.MEDIUM);
    dfa[4] = DateFormat.getDateInstance(DateFormat.LONG);
    dfa[5] = DateFormat.getDateInstance(DateFormat.FULL);

    Date d1 = new Date(100000000L);
    for (DateFormat df : dfa)
      System.out.println(df.format(d1));

    // parsing
    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    String s2 = df.format(d1);
    System.out.println(s2);
    try {
      Date d2 = df.parse(s2);
      System.out.println("parsed = " + d2.toString());
    } catch (ParseException pe) {
      System.out.println("parse exc");
    }
  }
}

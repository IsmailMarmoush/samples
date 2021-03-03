package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.util.Calendar;
import java.util.Date;

public class Calendars {
  public static void main(String[] args) {
    Date d1 = new Date(1000000000000L);
    System.out.println("1st date " + d1.toString());
    Calendar c = Calendar.getInstance();
    c.setTime(d1); // #1
    if (Calendar.SUNDAY == c.getFirstDayOfWeek()) // #2
      System.out.println("Sunday is the first day of the week");
    System.out.println("trillionth milli day of week is " + c.get(Calendar.DAY_OF_WEEK)); // #3
    c.add(Calendar.MONTH, 1); // #4
    Date d2 = c.getTime(); // #5
    System.out.println("new date " + d2.toString());

    /*
     * The roll() method acts like the add() method, except that when a part
     * of a Date gets incremented or decremented, larger parts of the Date
     * will not get incremented or decremented.
     *
     * Notice that the year did not change, even though we added 9 months to
     * an October date. In a similar fashion, invoking roll() with HOUR
     * won't change the date, the month, or the year.
     */
    // assume c is October 8, 2001
    c.roll(Calendar.MONTH, 9); // notice the year in the output
    Date d4 = c.getTime();
    System.out.println("new date " + d4.toString());
  }
}

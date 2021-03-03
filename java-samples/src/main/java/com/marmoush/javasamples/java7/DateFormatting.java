package com.marmoush.javasamples.java7;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateFormatting {
  public static void main(String[] args) throws ParseException {
    DateFormat s = DateFormat.getDateInstance(DateFormat.SHORT);
    DateFormat m = DateFormat.getDateInstance(DateFormat.MEDIUM);
    DateFormat l = DateFormat.getDateInstance(DateFormat.LONG);
    DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);

    Date d = new GregorianCalendar(2015, Calendar.JULY, 4).getTime();
    System.out.println(s.format(d)); // 7/4/15
    System.out.println(m.format(d)); // Jul 4, 2015
    System.out.println(l.format(d)); // July 4, 2015
    System.out.println(f.format(d)); // Saturday, July 4, 2015

    SimpleDateFormat f1 = new SimpleDateFormat("MM dd yyyy hh:mm:ss");
    SimpleDateFormat f2 = new SimpleDateFormat("MMMM yyyy");
    SimpleDateFormat f3 = new SimpleDateFormat("hh");

    Date date = f1.parse("01 26 2016 01:22:33");
    System.out.println(f2.format(date)); // January 2016
    System.out.println(f3.format(date)); // 01
  }
}

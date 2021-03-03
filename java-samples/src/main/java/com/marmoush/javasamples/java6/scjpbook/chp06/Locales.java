package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Locales {
  public static void main(String[] args) {

    /*
     * Remember that both DateFormat and NumberFormat objects can have their
     * locales set only at the time of instantiation. Watch for code that
     * attempts to change the locale of an existing instance�no such methods
     * exist!
     */

    Calendar c = Calendar.getInstance();
    c.set(2010, 11, 14); // December 14, 2010
    // (month is 0-based
    Date d2 = c.getTime();

    DateFormat dfUS = DateFormat.getInstance();
    System.out.println("US " + dfUS.format(d2));

    DateFormat dfUSfull = DateFormat.getDateInstance(DateFormat.FULL);
    System.out.println("US full " + dfUSfull.format(d2));

    Locale locIT = new Locale("it", "IT"); // Italy
    DateFormat dfIT = DateFormat.getDateInstance(DateFormat.FULL, locIT);
    System.out.println("Italy " + dfIT.format(d2));

    /*
     * There are a couple more methods in Locale (getDisplayCountry() and
     * getDisplayLanguage()) that you'll have to know for the exam. These
     * methods let you create Strings that represent a given locale's
     * country and language in terms of both the default locale and any
     * other locale:
     */
    Locale locBR2 = new Locale("pt", "BR"); // Brazil
    System.out.println("def " + locBR2.getDisplayCountry());
    System.out.println("loc " + locBR2.getDisplayCountry(locBR2));

    Locale locDK = new Locale("da", "DK"); // Denmark
    System.out.println("def " + locDK.getDisplayLanguage());
    System.out.println("loc " + locDK.getDisplayLanguage(locDK));

    Locale locIT2 = new Locale("it", "IT"); // Italy
    System.out.println("Def " + locDK.getDisplayLanguage(locIT2));
  }
}

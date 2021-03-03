package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatting {
  public static void main(String[] args) {
    float f1 = 123.4567f;
    Locale locFR = new Locale("fr"); // France
    NumberFormat[] nfa = new NumberFormat[4];
    nfa[0] = NumberFormat.getInstance();
    nfa[1] = NumberFormat.getInstance(locFR);
    nfa[2] = NumberFormat.getPercentInstance();
    nfa[3] = NumberFormat.getCurrencyInstance(locFR);
    for (NumberFormat nf : nfa)
      System.out.println(nf.format(f1));

    NumberFormat nf = NumberFormat.getInstance();
    System.out.println(nf.getMaximumFractionDigits() + " ");
    System.out.println(nf.format(f1) + " ");
    nf.setMaximumFractionDigits(5);
    System.out.println(nf.format(f1) + " ");
    try {
      System.out.println(nf.parse("1234.567"));
      // nf.setParseIntegerOnly(true);
      System.out.println(nf.parse("1234.567daf222"));
    } catch (ParseException pe) {
      System.out.println("parse exc");
    }
  }
}

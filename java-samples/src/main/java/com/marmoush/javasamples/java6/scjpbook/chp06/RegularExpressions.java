package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
  public static void main(String[] args) {
    Pattern p1 = Pattern.compile("[^a]"); // all except a
    Matcher m1 = p1.matcher("baa3ab33#a 2@3 33"); // the source
    while (m1.find()) {
      System.out.print(m1.start() + " ");
    }

    /** ********************************************************************** */
    System.out.println();
    System.out.println("-----------------------");
    /** ********************************************************************** */
    Pattern p2 = Pattern.compile("0[xX][0-9a-fA-F]"); // hexa
    Matcher m2 = p2.matcher("12 0x 0x12 0Xf 0xg "); // the source
    while (m2.find()) {
      System.out.print(m2.start() + ":" + m2.end() + "  ");
    }

    /** ********************************************************************** */
    System.out.println();
    System.out.println("-----------------------");
    /** ********************************************************************** */
    Pattern p3 = Pattern.compile("[\\d]?");
    Matcher m3 = p3.matcher("012 23 1 0 011"); // the source
    while (m3.find()) {
      System.out.print(m3.start() + ":" + m3.end() + "  ");
    }

    /** ********************************************************************** */
    System.out.println();
    System.out.println("-----------------------");
    /** ********************************************************************** */
    Pattern p4 = Pattern.compile("proj1([^,])*");
    Matcher m4 = p4.matcher("proj1.txt,proj1dsched.pdf,proj1,proj2,proj1.java"); // the
    // source
    while (m4.find()) {
      System.out.print(m4.start() + ":" + m4.end() + "  ");
    }

    /** ********************************************************************** */
    System.out.println();
    System.out.println("-----------------------");
    /** ********************************************************************** */
    Pattern p5 = Pattern.compile("[^,]+ds");
    Matcher m5 = p5.matcher("proj1.txt,proj1dsched.pdf,proj1,proj2,proj1.java"); // the
    // source
    while (m5.find()) {
      System.out.print(m5.start() + ":" + m5.end() + "  ");
    }

    /** ********************************************************************** */
    System.out.println();
    System.out.println("-----------------------");
    /** ********************************************************************** */
    Pattern p6 = Pattern.compile("[^,]+");
    Matcher m6 = p6.matcher("proj1.txt,proj1dsched.pdf,proj1,proj2,proj1.java"); // the
    // source
    while (m6.find()) {
      System.out.print(m6.start() + ":" + m6.end() + "  ");
      System.out.print(m6.group() + "  ");
    }

    /** ********************************************************************** */
    System.out.println();
    System.out.println("-----------------------");
    /** ********************************************************************** */
    Pattern p7 = Pattern.compile(".*?xx");
    Matcher m7 = p7.matcher("yyxxxyxx"); // the
    // source
    while (m7.find()) {
      System.out.print(m7.start() + ":" + m7.end() + "  ");
      System.out.print(m7.group() + "  ");
    }

    /** ********************************************************************** */
    System.out.println();
    System.out.println("-----------------------");
    /** ********************************************************************** */
    Pattern p8 = Pattern.compile("\\w+\\.[a-zA-Z]+");
    Matcher m8 = p8.matcher("proj1.txt,proj1dsched.pdf,proj1,proj2.pdf,proj1.java"); // the
    // source
    while (m8.find()) {
      System.out.print(m8.start() + ":" + m8.end() + "  ");
      System.out.print(m8.group() + "  ");
    }
    // \d A digit
    // \s A whitespace character
    // \w A word character (letters, digits, or "_" (underscore))

    // [abc] Searches only for a's, b's or c's
    // [a-f] Searches only for a, b, c, d, e, or f characters
    // [a-fA-F] Searches for the first six letters of the alphabet, both
    // cases.

    // one-digit hexadecimal numbers:0[xX][0-9a-fA-F]

    // ^ negate
    // + one or more
    // * zero or more
    // ? zero or one

    /*
     * There is a set of regex constructs called quantifiers that let us
     * specify concepts such as "one or more." In fact, the quantifier that
     * represents "one or more" is the "+" character.
     */

    // The key part of this expression is the
    // "give me zero or more characters that aren't a comma."
    // proj1([^,])*

    // "zero or one instance of either a space or a dash" in the middle of
    // our digits: \d\d\d([-\s])?\d\d\d\d

    /*
     * "." (dot) metacharacter. When you see this character in a regex
     * expression, it means "any character can serve here."
     *
     * source: "ac abc a c" pattern: a.c will produce the output 3 abc 7 a c
     */

    // ? is greedy, ?? is reluctant, for zero or once
    // * is greedy, *? is reluctant, for zero or more
    // + is greedy, +? is reluctant, for one or more

  }
}

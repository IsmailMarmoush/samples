package com.marmoush.javasamples.java6.scjpbook.chp06;

public class Strings {
  public static void main(String[] args) {
    /*
     * In Java, each character in a string is a 16-bit Unicode character.
     * Because Unicode characters are 16 bits (not the skimpy 7 or 8 bits
     * that ASCII provides), a rich, international set of characters is
     * easily represented in Unicode.
     */
    String s = "abcdef";
    // the concat() method 'appends'
    // a literal to the end
    s = s.concat(" more stuff");
    /*
     * Technically:
     *
     * 1- "more stuff" is object
     *
     * 2- s.concat is object
     *
     * 3- old s is object
     */

    System.out.println("***************************************************");
    String x = "0123456789";
    // as if by magic, the value
    // of each char
    // is the same as its index!
    System.out.println(x.substring(5));
    // output is "56789"
    System.out.println(x.substring(5, 8));
    // output is "567"

    System.out.println("***************************************************");
    String s1 = new String("abc"); // creates two objects,
    String s2 = new String("abc");
    System.out.println(s1 == s2);
    String s3 = "abc";
    String s4 = "abc";
    System.out.println(s3 == s4);

    System.out.println("***************************************************");
    String z = "big surprise";
    System.out.println(z.toString());

    System.out.println("***************************************************");
    // and one reference variable
    // In this case, because we used the new keyword, Java will create a new
    // String object in normal (nonpool) memory, and s will refer to it. In
    // addition, the literal "abc" will be placed in the pool.
    String x2 = "big surprise";
    System.out.println(x2.toString());
    StringBuffer sb1 = new StringBuffer("hello");
    StringBuffer sb2 = new StringBuffer("hello");
    System.out.println(sb1.equals(sb2));
    StringBuilder sb3 = new StringBuilder("hello");
    StringBuilder sb4 = new StringBuilder("hello");
    System.out.println(sb3.equals(sb4));
  }
}

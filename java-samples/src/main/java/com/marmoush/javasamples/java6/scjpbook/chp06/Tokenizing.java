package com.marmoush.javasamples.java6.scjpbook.chp06;

public class Tokenizing {
  public static void main(String[] args) {
    /*
     * (Note: Remember that to represent
     * "\" in a string you may need to use the escape sequence "\\" .
     * Because of this, and depending on your OS, your second argument might
     * have to be " \\d" or even "\\\\d".)
     */
    String arg0 = "ab5 cc c 45 @";
    String[] tokens = arg0.split("\\d");
    System.out.println("Number of tokens: " + tokens.length);
    for (String s : tokens)
      System.out.println(">" + s + "<");

    /** ************************************************* */
    System.out.println("-------------------------------");
    /** ************************************************* */
    String s = "ab.cde.fg";
    String[] tokens2 = s.split("\\.");
    for (String s2 : tokens2)
      System.out.println(">" + s2 + "<");
  }
}

package com.marmoush.javasamples.java6.scjpbook.chp10;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.toHexString;
import static java.lang.System.out;

/*
 * Static imports can be used when you want to use a class's static members.
 */

public class StaticImports {}

class TestStaticImport {
  String $ = "hello";

  /*
   * Watch out for ambiguously named static members. For instance, if you do a
   * static import for both the Integer class and the Long class, referring to
   * MAX_VALUE will cause a compiler error, since both Integer and Long have a
   * MAX_VALUE constant, and Java won't know which MAX_VALUE you're referring
   * to
   */
  /*
   * You can do a static import on static object references, constants
   * (remember they're static and final), and static methods.
   */

  public static void main(String[] args) {
    out.println(MAX_VALUE); // 3
    out.println(toHexString(42)); // 4
  }
}

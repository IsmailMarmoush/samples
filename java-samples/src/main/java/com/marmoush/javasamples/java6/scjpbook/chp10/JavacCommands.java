package com.marmoush.javasamples.java6.scjpbook.chp10;

public class JavacCommands {
  // javac [ options ] [ sourcefiles ] [ @argfiles ]

  /* ****************** [OPTIONS] ************************** */
  /*
   * -classpath
   *
   * Set the user class path, overriding the user class path in the CLASSPATH
   * environment variable. If neither CLASSPATH or -classpath is specified,
   * the user class path consists of the current directory.
   */

  /*
   * javac -d classes source/MyClass.java
   *
   * The -d option lets you tell the compiler in which directory to put the
   * .class file(s) it generates (d is for destination)
   *
   * javac -d ../classes com/wickedlysmart/MyClass.java
   */

  // Handling Command-Line Arguments
  public static void main(String[] args) {
    int x = 0;
    for (String s : args)
      System.out.println(x++ + " element = " + s);
  }

  // The following are all legal declarations for main():
  // static public void main(String[] args)
  // public static void main(String... x)
  // static public void main(String bang_a_gong[])

  // Declaring and Using Classpaths
  /*
   * Most of the path-related questions on the exam will use Unix conventions.
   * If you are a Windows user, your directories will be declared using
   * backslashes (\) and the separator character you use will be a semicolon
   * (;). But again, you will NOT need any shell-specific knowledge for the
   * exam.
   */

  /*
   * The way to tell java or javac to search in the current directory is to
   * add a dot (.) to the classpath: -classpath /com/foo/acct:/com/foo:.
   */

  /*
   * (Remember, we're talking about class files�when you're telling javac
   * which .java file to compile, javac looks in the current directory by
   * default.)
   */
  /*
   * remember that classpaths are searched from left to right.
   *
   * -classpath /com:/foo:. is not the same as -classpath .:/foo:/com
   */
}

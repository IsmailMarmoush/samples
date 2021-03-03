package com.marmoush.javasamples.java6.scjpbook.chp10;

public class Jars {
  // jar -cf MyJar.jar myApp
  // javac -classpath ws/myApp.jar UseStuff.java
  /*
   * When you use an import statement you are declaring only one package. When
   * you say import java.util.*; you are saying
   * "Use the short name for all of the classes in the java.util package."
   * You�re NOT getting the java.util.jar classes or java.util.regex packages!
   * Those packages are totally independent of each other; the only thing they
   * share is the same "root" directory, but they are not the same packages.
   * As a corollary, you can�t say import java.*; in the hopes of importing
   * multiple packages �just remember, an import statement can import only a
   * single package.
   */

  /*
   * It�s possible to create environment variables that provide an alias for
   * long classpaths. The classpath for some of the JAR files in J2SE can be
   * quite long, and so it�s common for such an alias to be used when defining
   * a classpath. If you see something like JAVA_HOME or $JAVA_HOME in an exam
   * question it just means
   * "That part of the absolute classpath up to the directories we�re specifying explicitly."
   * You can assume that the JAVA_HOME literal means this, and is pre-pended
   * to the partial classpath you see.
   */
}

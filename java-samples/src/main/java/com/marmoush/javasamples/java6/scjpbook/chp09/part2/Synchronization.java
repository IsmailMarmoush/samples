package com.marmoush.javasamples.java6.scjpbook.chp09.part2;

public class Synchronization {}

class SyncTest {
  /*
   * Threads calling non-static synchronized methods in the same class will
   * only block each other if they're invoked using the same instance. That's
   * because they each lock on this instance, and if they're called using two
   * different instances, they get two locks, which do not interfere with each
   * other.
   *
   * Threads calling static synchronized methods in the same class will always
   * block each other�they all lock on the same Class instance.
   *
   * A static synchronized method and a non-static synchronized method will
   * not block each other, ever. The static method locks on a Class instance
   * while the non-static method locks on the this instance�these actions do
   * not interfere with each other at all.
   *
   * For synchronized blocks, you have to look at exactly what object has been
   * used for locking. (What's inside the parentheses after the word
   * synchronized?) Threads that synchronize on the same object will block
   * each other. Threads that synchronize on different objects will not.
   */

  private static int count;
  /*
   * Two threads executing the same method at the same time will use different
   * copies of the local variables, and they won't bother each other. However,
   * you do need to worry about static and non-static fields, if they contain
   * data that can be changed.
   */
  // We could synchronize on a String object, but strings cannot be modified
  // once they are created,
  private String x, y;

  /*
   * it's called class literal. It's a special feature in the Java language
   * that tells the compiler (who tells the JVM): go and find me the instance
   * of Class that represents the class called MyClass. You can also do this
   * with the following code:
   */
  public static void classMethod() throws ClassNotFoundException {
    Class cl = Class.forName("SyncTest");
    synchronized (cl) {
      // do stuff
    }
  }

  public static synchronized int getCount1() {
    return count;
  }

  public static int getCount2() {
    synchronized (SyncTest.class) {
      return count;
    }
  }

  public void doStuff() {
    System.out.println("not synchronized");

    synchronized (this) {
      x = "Hello Synched";
      System.out.println("synchronized");
    }
  }

  public synchronized void doStuff2() {
    System.out.println("synchronized");
  }
}

package com.marmoush.javasamples.java6.scjpbook.chp09.part2;

public class AnotherDeadLock {
  public static void main(String[] args) {
    final Object resource1 = "resource1";
    final Object resource2 = "resource2";
    // t1 tries to lock resource1 then resource2
    Thread t1 = new Thread() {
      @Override
      public void run() {
        // Lock resource 1
        synchronized (resource1) {
          System.out.println("Thread 1: locked resource 1");

          try {
            Thread.sleep(50);
          } catch (InterruptedException e) {
          }

          synchronized (resource2) {
            System.out.println("Thread 1: locked resource 2");
          }
        }
      }
    };

    // t2 tries to lock resource2 then resource1
    Thread t2 = new Thread() {
      @Override
      public void run() {
        synchronized (resource2) {
          System.out.println("Thread 2: locked resource 2");

          try {
            Thread.sleep(50);
          } catch (InterruptedException e) {
          }

          synchronized (resource1) {
            System.out.println("Thread 2: locked resource 1");
          }
        }
      }
    };

    // If all goes as planned, deadlock will occur,
    // and the program will never exit.
    t1.start();
    t2.start();
  }
}

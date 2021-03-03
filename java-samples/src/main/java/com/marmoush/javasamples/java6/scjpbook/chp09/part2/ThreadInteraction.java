package com.marmoush.javasamples.java6.scjpbook.chp09.part2;

class ThreadA {
  public static void main(String[] args) {
    ThreadB b = new ThreadB();
    b.start();

    synchronized (b) {
      try {
        System.out.println("Waiting for b to complete...");
        b.wait();
      } catch (InterruptedException e) {

      }
      System.out.println("Total is: " + b.total);
    }
  }
}

class ThreadB extends Thread {
  int total;

  @Override
  public void run() {
    synchronized (this) {
      for (int i = 0; i < 100; i++) {
        total += i;
      }
      notify();
    }
  }
}

class ThreadC implements Runnable {
  int total;

  public ThreadC() {}

  @Override
  public void run() {
    synchronized (this) {
      for (int i = 0; i < 100; i++) {
        total += i;
      }
      notify();
    }
  }
}

public class ThreadInteraction {
  /*
   * wait(), notify(), and notifyAll() must be called from within a
   * synchronized context! A thread can't invoke a wait or notify method on an
   * object unless it owns that object's lock.
   */
  /*
   * A thread gets on this waiting list by executing the wait() method of the
   * target object. From that moment, it doesn't execute any further
   * instructions until the notify() method of the target object is called.
   */
  /*
   * When the wait() method is invoked on an object, the thread executing that
   * code gives up its lock on the object immediately. However, when notify()
   * is called, that doesn�t mean the thread gives up its lock at that moment.
   * If the thread is still completing synchronized code, the lock is not
   * released until the thread moves out of synchronized code. So just because
   * notify() is called doesn�t mean the lock becomes available at that
   * moment.
   */

}

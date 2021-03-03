package com.marmoush.javasamples.java6.scjpbook.chp09.part1;

public class InstantiatingThreads {
  public static void main(String[] args) {
    // Important Note
    /*
     * threads will start running in the order in which they were started
     * (in other words, the order in which start() was invoked on each
     * thread).
     */
    // Make one Runnable
    NameRunnable nr = new NameRunnable();
    Thread one = new Thread(nr);
    Thread two = new Thread(nr);
    Thread three = new Thread(nr);
    one.setName("Fred");
    two.setName("Lucy");
    three.setName("Ricky");
    one.start();
    two.start();
    three.start();
    /*
     * What you can't do, though, is call start() again. Once a thread has
     * been started, it can never be started again.
     *
     * An IllegalThreadStateException, which is a kind of RuntimeException
     * is thrown
     *
     * This happens whether or not the run() method has completed from the
     * first start() call.
     */
  }
}

class NameRunnable implements Runnable {
  @Override
  public void run() {
    for (int x = 1; x <= 3; x++) {
      System.out.println("Run by " + Thread.currentThread().getName() + ", x is " + x);
    }
  }
}

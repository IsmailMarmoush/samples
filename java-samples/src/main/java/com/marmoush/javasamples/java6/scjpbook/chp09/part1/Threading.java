package com.marmoush.javasamples.java6.scjpbook.chp09.part1;

class MyRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println("Important job running in MyRunnable");
  }
}

class MyThread extends Thread {
  @Override
  public void run() {
    System.out.println("Important job running in MyThread");
  }

  /*
   * the overloaded run method won't run by it self the thread class expects
   * run() with no args... also if u run it(overloaded) in run() it won't run
   * in separate thread.
   */
  public void run(String s) {
    System.out.println("String in run is " + s);
  }
}

public class Threading {
  /*
   * You can define and instantiate a thread in one of two ways:
   *
   * Extend the java.lang.Thread class. Implement the Runnable interface.
   */
  /*
   * It always needs a Thread Obj no matter the method(implement,
   * extend)thread class
   */
  public static void main(String[] args) {
    // If Extending
    MyThread t1 = new MyThread();

    // If Implementing
    MyRunnable r1 = new MyRunnable();
    Thread t2 = new Thread(r1); // Pass your Runnable to the Thread

    /*
     * Same Target Many Threads several threads of execution will be running
     * the very same job (and that the same job will be done multiple
     * times).
     */
    MyRunnable r2 = new MyRunnable();
    Thread foo = new Thread(r2);
    Thread bar = new Thread(r2);
    Thread bat = new Thread(r2);
  }
}

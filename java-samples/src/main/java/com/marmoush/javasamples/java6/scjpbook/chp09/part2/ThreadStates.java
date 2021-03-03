package com.marmoush.javasamples.java6.scjpbook.chp09.part2;

class RunnableThread implements Runnable {
  @Override
  public void run() {
    for (int i = 20; i > 0; i--) {
      try {
        System.out.println("Timer: " + i);
        Thread.sleep(1 * 1000); // Sleep for 1 Second

      } catch (InterruptedException ex) {
      }
    }
  }
}

public class ThreadStates {
  // New
  // Runnable
  // Running
  // Wait, blocked, Sleep
  // Dead

  /*
   * The important point is that one thread does not tell another thread to
   * block.
   */
  /*
   * If you have a reference t to another thread, you can write something like
   * this: t.sleep(); or t.yield() But those are actually static methods of
   * the Thread class�they don't affect the instance t; instead they are
   * defined to always affect the thread that's currently executing. (This is
   * a good example of why it's a bad idea to use an instance variable to
   * access a static method�it's misleading. There is a method, suspend(), in
   * the Thread class, that lets one thread tell another to suspend, but the
   * suspend() method has been deprecated and won't be on the exam (nor will
   * its counterpart resume()).
   */
  /*
   * There is also a stop() method, but it too has been deprecated and we
   * won't even go there. Both suspend() and stop() turned out to be very
   * dangerous, so you shouldn't use them and again, because they're
   * deprecated, they won't appear on the exam. Don't study 'em, don't use
   * 'em. Note also that a thread in a blocked state is still considered to be
   * alive.
   */
  public static void main(String[] args) {
    Thread mythread = new Thread(new RunnableThread());
    // Thread.MIN_PRIORITY (1)
    // Thread.NORM_PRIORITY (5)
    // Thread.MAX_PRIORITY (10)
    mythread.setPriority(Thread.NORM_PRIORITY); // not guranteed
    mythread.start();
    try {
      mythread.wait();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

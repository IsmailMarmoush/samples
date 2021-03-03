package com.marmoush.javasamples.java6.scjpbook.chp09.part3;

public class Starter implements Runnable {
  static long flag = 3;

  public static void main(String[] args) {
    System.out.print(Thread.currentThread().getId() + " ");
    // insert code here
  }

  @Override
  public void run() {
    go(Thread.currentThread().getId());
  }

  void go(long id) {
    System.out.println(id);
  }
}
// And given the following five fragments:
// I. new Starter().run(); // 1 1
// II. new Starter().start();
// III. new Thread(new Starter());
// IV. new Thread(new Starter()).run(); // 1 1
// V. new Thread(new Starter()).start(); // 1 8

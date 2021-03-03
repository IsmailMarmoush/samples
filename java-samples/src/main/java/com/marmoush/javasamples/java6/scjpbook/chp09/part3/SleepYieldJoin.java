package com.marmoush.javasamples.java6.scjpbook.chp09.part3;

class MyThread1 extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Inside Thread: " + Thread.currentThread().getName());
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
  }
}

class MyThread2 extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Inside Thread: " + Thread.currentThread().getName());
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
  }
}

public class SleepYieldJoin {
  public static void main(String[] args) {
    MyThread1 mt1 = new MyThread1();
    mt1.start();
    // MyThread2 mt2 = new MyThread2();
    // mt2.start();
    for (int i = 0; i < 10; i++) {
      System.out.println("Inside Thread: " + Thread.currentThread().getName());
      try {
        Thread.sleep(500);
        mt1.join();
      } catch (InterruptedException e) {
      }
    }
  }
}

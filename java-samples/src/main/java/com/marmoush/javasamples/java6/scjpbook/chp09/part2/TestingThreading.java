package com.marmoush.javasamples.java6.scjpbook.chp09.part2;

class TestingObject {
  private String h = "Hello world";

  public TestingObject() {}

  public synchronized String getH() {
    return h;
  }

  public synchronized void setH(String s) {
    h = s;
  }

  public synchronized void loop1(int threadNum) throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      System.out.println("Loop 1 Round:" + i + "  " + h + " In Thread:" + threadNum);
      Thread.sleep(1000);
    }
  }

  public synchronized void loop2(int threadNum) throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      System.out.println("Loop 2 Round:" + i + "  " + h + " In Thread:" + threadNum);
      Thread.sleep(1000);
    }
  }
}

public class TestingThreading {
  public static void main(String[] args) {
    TestingObject to = new TestingObject();
    ThreadClass1 tc1 = new ThreadClass1(1, to);
    ThreadClass2 tc2 = new ThreadClass2(2, to);

    Thread thread1 = new Thread(tc1);
    Thread thread2 = new Thread(tc2);

    thread1.start();
    thread2.start();
  }
}

class ThreadClass1 implements Runnable {
  private int threadNum;
  private TestingObject to;

  public ThreadClass1(int threadNum, TestingObject to) {
    this.threadNum = threadNum;
    this.to = to;
  }

  @Override
  public void run() {
    try {
      this.to.loop1(this.threadNum);
    } catch (InterruptedException e) {

      e.printStackTrace();
    }
  }
}

class ThreadClass2 implements Runnable {
  private int threadNum;
  private TestingObject to;

  public ThreadClass2(int threadNum, TestingObject to) {
    this.threadNum = threadNum;
    this.to = to;
  }

  @Override
  public void run() {
    try {
      this.to.loop2(this.threadNum);
    } catch (InterruptedException e) {

      e.printStackTrace();
    }
  }
}

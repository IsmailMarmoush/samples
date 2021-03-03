package com.marmoush.javasamples.java6.scjpbook.chp09.part3;

class MyThread4 extends Thread {
  String[] args = new String[]{"NONE"};

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {

      System.out.println("Thread " + Thread.currentThread().getName() + "  Says " + args[0]);

      try {
        Thread.sleep(500);
        if (i == 5) {
          synchronized (args) {
            args.notifyAll();
          }
        }
      } catch (InterruptedException e) {
      }
    }
  }

  public void setArgs(String[] args) {
    this.args = args;
  }
}

public class WaitNotify {

  public static void main(String[] args) {
    args = new String[]{"Hello"};

    MyThread4 m0 = new MyThread4();
    m0.setName("zero");
    m0.setArgs(args);
    m0.start();

    synchronized (args) {
      try {
        args.wait();

      } catch (InterruptedException e) {
        System.out.println("exception throw from wait");
        e.printStackTrace();
      }
    }
    for (int i = 0; i < 10; i++) {
      System.out.println("Thread " + Thread.currentThread().getName() + "  Can now Say " + args[0]);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
      }
    }
    System.out.print("3 ");
  }
}

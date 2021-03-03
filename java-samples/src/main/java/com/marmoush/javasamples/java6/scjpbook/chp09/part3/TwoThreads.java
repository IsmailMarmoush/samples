package com.marmoush.javasamples.java6.scjpbook.chp09.part3;

public class TwoThreads {
  static Thread laurel, hardy;

  public static void main(String[] args) {

    laurel = new Thread() {
      @Override
      public void run() {
        System.out.println("A");
        try {
          // Thread.sleep(1000);
          Thread.sleep(1000);
        } catch (Exception e) {
          System.out.println("B");
        }
        System.out.println("C");
      }
    };
    hardy = new Thread() {
      @Override
      public void run() {
        System.out.println("D");
        try {

          laurel.wait();
          // System.out.println(laurel.getName() + "hello");
        } catch (Exception e) {
          System.out.println("E");
        }
        System.out.println("F");
      }
    };
    laurel.start();
    hardy.start();
  }
}

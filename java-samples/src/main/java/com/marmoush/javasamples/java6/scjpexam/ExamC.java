package com.marmoush.javasamples.java6.scjpexam;

public class ExamC implements Runnable {
  public static void main(String[] args) throws Exception {
    Thread t = new Thread(new ExamC());

    t.start();
    t.join();
    for (int i = 0; i < 6; i++) {
      System.out.println("in Main");
      Thread.sleep(500);
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < 6; i++) {
      System.out.println(i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {

        e.printStackTrace();
      }
    }
  }
}

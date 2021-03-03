package com.marmoush.javasamples.java8.OCP.ch07;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Cycling Barriers
public class Zoo {

  public static void main(String[] args) {
    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool(4);
      Zoo manager = new Zoo();
      CyclicBarrier c = new CyclicBarrier(4, () -> System.out.println("-----------------  Animals removed"));
      CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println("-----------------  Cleaning Done"));
      for (int i = 0; i < 12; i++) {
        service.submit(() -> manager.performTask(c, c2));
      }
    } finally {
      if (service != null)
        service.shutdown();
    }
  }

  public void performTask(CyclicBarrier c, CyclicBarrier c2) {
    try {
      removeAnimals();
      c.await();
      cleanPen();
      c2.await();

    } catch (InterruptedException | BrokenBarrierException e) {
      // Handle checked exceptions here
    }
  }

  private void removeAnimals() {
    System.out.println("Removing animals");
  }

  private void cleanPen() {
    System.out.println("Cleaning the pen");
  }

  private void addAnimals() {
    System.out.println("Adding animals");
  }
}

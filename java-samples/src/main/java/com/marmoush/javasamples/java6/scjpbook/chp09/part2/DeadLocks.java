package com.marmoush.javasamples.java6.scjpbook.chp09.part2;

class DeadlockRisk {
  private Resource resourceA = new Resource();
  private Resource resourceB = new Resource();

  public int read() {
    synchronized (resourceA) { // May deadlock here
      synchronized (resourceB) {
        System.out.println("hellow world");
        return resourceB.value + resourceA.value;
      }
    }
  }

  public void write(int a, int b) {
    synchronized (resourceB) { // May deadlock here
      synchronized (resourceA) {
        System.out.println("hellow world");
        resourceA.value = a;
        resourceB.value = b;
      }
    }
  }

  private static class Resource {
    public int value;
  }
}

public class DeadLocks {
  public static void main(String[] args) {
    DeadlockRisk dl = new DeadlockRisk();
    dl.read();
    dl.write(3, 3);
  }
}

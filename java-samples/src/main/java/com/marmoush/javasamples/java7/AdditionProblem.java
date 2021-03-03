package com.marmoush.javasamples.java7;

import java.util.concurrent.RecursiveTask;

class AdditionProblem extends RecursiveTask<Integer> {

  private static final long serialVersionUID = -5074782992221947316L;

  int seedArray[] = null;

  private int seedCount = -1;

  public AdditionProblem(int start, int end) {
    System.out.println("I'm created:" + this.hashCode());
    seedArray = seed(start, end);
  }

  private int[] seed(int start, int end) {
    int seedArray[] = new int[(end - start) + 1];

    for (int i = 0; i < seedArray.length; i++) {
      seedArray[i] = start++;
    }
    return seedArray;
  }

  public AdditionProblem(int seeds) {
    seedArray = seed(seeds);
    setSeedCount(seedArray.length);
  }

  private int[] seed(int s) {
    int seedArray[] = new int[s];

    for (int i = 0; i < seedArray.length; i++) {
      seedArray[i] = i;
    }
    return seedArray;
  }

  public static void main(String[] args) {

    AdditionProblem problem = new AdditionProblem(0, 10);
    int result = problem.compute();

    System.out.println("Result:" + result);
  }

  public Integer compute() {
    int result = 0;
    for (int n : seedArray) {
      result = result + n;
    }
    return result;
  }

  public int getSeedCount() {
    return seedCount;
  }

  public void setSeedCount(int seedCount) {
    this.seedCount = seedCount;
  }
}

package com.marmoush.javasamples.java8.OCA;

public class _AssessmentExam {
  static int $;

  public static void main(String[] args) {
    boolean keepGoing = true;
    int count = 0;
    int x = 3;
    while (count++ < 3) {
      int y = (1 + 2 * count) % 3;
      switch (y) {
        case 0:
          x -= 1;
          break;
        default:

        case 1:
          x += 5;
      }
    }
    System.out.println(x);
  }
}

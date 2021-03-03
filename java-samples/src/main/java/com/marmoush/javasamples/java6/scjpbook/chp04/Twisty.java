package com.marmoush.javasamples.java6.scjpbook.chp04;

public class Twisty {

  int index;

  {
    index = 1;
  }

  public static void main(String[] args) {

    new Twisty().go();
  }

  void go() {

    int[][] dd = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1, 0}};
    System.out.println(index);
    System.out.println(index++ + "     " + index++);
    System.out.println(index);
    // System.out.println(dd[index++][index++]);

  }
}

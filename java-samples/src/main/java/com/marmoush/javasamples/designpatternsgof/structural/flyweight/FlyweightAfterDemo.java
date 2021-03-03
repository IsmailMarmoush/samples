package com.marmoush.javasamples.designpatternsgof.structural.flyweight;

class GazillionAfter {
  private int row;

  public GazillionAfter(int theRow) {
    row = theRow;
    System.out.println("ctor: " + row);
  }

  void report(int theCol) {
    System.out.print(" " + row + theCol);
  }
}

class Factory {
  private GazillionAfter[] pool;

  public Factory(int maxRows) {
    pool = new GazillionAfter[maxRows];
  }

  public GazillionAfter getFlyweight(int theRow) {
    if (pool[theRow] == null)
      pool[theRow] = new GazillionAfter(theRow);
    return pool[theRow];
  }
}

public class FlyweightAfterDemo {
  public static final int ROWS = 6, COLS = 10;

  public static void main(String[] args) {
    Factory theFactory = new Factory(ROWS);
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++)
        theFactory.getFlyweight(i).report(j);
      System.out.println();
    }
  }
}

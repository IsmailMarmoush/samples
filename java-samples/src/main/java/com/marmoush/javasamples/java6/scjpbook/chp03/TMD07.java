package com.marmoush.javasamples.java6.scjpbook.chp03;

public class TMD07 {

  public static void main(String[] args) {
    System.out.println(Suits.NOTRUMP.getValue(3));
    System.out.println(Suits.SPADES + " " + Suits.SPADES.points);
    System.out.println(Suits.values());
  }

  public enum Suits {
    CLUBS(20),
    DIAMONDS(20),
    HEARTS(30),
    SPADES(30),
    NOTRUMP(40) {
      @Override
      public int getValue(int bid) {
        return ((bid - 1) * 30) + 40;
      }
    };
    private int points;

    Suits(int points) {
      this.points = points;
    }

    public int getValue(int bid) {
      return points * bid;
    }
  }
}

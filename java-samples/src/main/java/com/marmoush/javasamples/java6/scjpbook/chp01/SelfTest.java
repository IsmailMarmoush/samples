package com.marmoush.javasamples.java6.scjpbook.chp01;

enum Animals {
  DOG("woof"),
  CAT("meow"),
  FISH("burble");
  private String sound;

  Animals(String s) {
    sound = s;
  }

  public String getSound() {
    return sound;
  }
}

class Implementer implements Interface1 {
  // can throw same exception or a child of it
  @Override
  public void sayHi() throws ExceptionChild {}
}

strictfp class Frodo extends Hobbit {
  public Frodo() {
    int hi[] = {};
    Animals dog = Animals.DOG;
    System.out.println(dog.getSound());
  }

  strictfp void hello() {}
}

class Hobbit {
  int countGold(int x, int y) {
    return x + y;
  }
}

public class SelfTest extends Hobbit {
  static Animals a;

  public SelfTest() {}

  ;

  public static void main(String[] args) {
    System.out.println(Animals.DOG.getSound() + " " + Animals.FISH.getSound());
    long[] x[];
    Boolean[] ba[];

    for (Days d : Days.values())
      ;
    Days[] d2 = Days.values();
    System.out.println(d2[2]);

    Short myGold = 7;
    // System.out.println(countGold(myGold, 6));
  }

  public enum Days {
    MON,
    TUE,
    WED
  }

  enum Traffic {
    RED,
    YELLOW,
    GREEN
  }

  ;
}

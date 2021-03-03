package com.marmoush.javasamples.java6.scjpbook.chp03;

class Fizz {
  int x = 5;
}

class Mixer {
  Mixer m1;

  Mixer() {}

  Mixer(Mixer m) {
    m1 = m;
  }

  void go() {
    System.out.print("hi ");
  }
}

public class SelfTest {
  public static void main(String[] args) {
    int[][] a = {{1, 2,}, {3, 4,}};
    System.out.println(a[0].length);
    Mixer m2 = new Mixer();
    Mixer m3 = new Mixer(m2);
    m3.go();
    Mixer m4 = m3.m1;
    m4.go();
    Mixer m5 = m2.m1;
    // m5.go();

    final Fizz f1 = new Fizz();
    Fizz f2 = new Fizz();
    Fizz f3 = FizzSwitch(f1, f2);
    System.out.println((f1 == f3) + " " + (f1.x == f3.x));

    Integer i = 42;
    String s = (i < 40) ? "life" : (i > 50) ? "universe" : "everything";
    System.out.println(s);

    float k = 3.0f;
    if (k == i)
      ;
  }

  static Fizz FizzSwitch(Fizz x, Fizz y) {
    final Fizz z = x;
    z.x = 6;
    return z;
  }
}

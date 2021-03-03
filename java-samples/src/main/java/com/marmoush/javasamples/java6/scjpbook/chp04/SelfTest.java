package com.marmoush.javasamples.java6.scjpbook.chp04;

public class SelfTest {
  public static void main(String[] args) {
    question02();
    System.out.println("------------");
    question04();
    System.out.println("------------");
    question06();
  }

  static void question02() {

    float f1 = 2.3f;
    float[][] f2 = {{42.0f}, {1.7f, 2.3f}, {2.6f, 2.7f}};
    float[] f3 = {2.7f};
    Long x = 42L;
    // insert code here
    if (x == f2[0][0])
      System.out.println("true");
    System.out.print(7 + 2 + 3 + " ");
    Boolean b2 = false;
    if ((b2 = true)) // | (21 % 5) > 2)
      System.out.println("x");
  }

  static void question04() {
    Long x = 42L;
    Long y = 44L;
    class hi {
      // just testing
    }

    System.out.print(" " + 7 + 2 + " ");
    System.out.print(foo() + x + 5 + " ");
    System.out.println(x + y + foo());
  }

  static void question06() {
    int index = 1;
    int[][] dd = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1, 0}};
    System.out.println(dd[index++][index++]);

    if ((6 < 8) ^ false)
      System.out.println(3);
    int key = 3;
    switch (key) {
      default:
        System.out.println("Switch is default");
        break;
      case 3:
        System.out.println("Switch is 3");
        break;
    }
  }

  static String foo() {
    return "foo";
  }
}

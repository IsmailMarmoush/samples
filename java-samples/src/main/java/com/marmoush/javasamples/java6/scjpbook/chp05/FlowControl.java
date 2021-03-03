package com.marmoush.javasamples.java6.scjpbook.chp05;

public class FlowControl {

  /* @param args  */
  public static void main(String[] args) {
    boolean boo = false;
    if (boo = true) {
      // succeeds
    }

    int x = 3;
    // if (x = 5)
    // Won't compile because x is not a boolean!
    String d = "h";

    int temp = 90;
    switch (temp) {
      case 80:
        System.out.println("80");
        // case 80 : System.out.println("80"); // won't compile!
      case 90: {
        System.out.println("90");
      }
      default:
        System.out.println("default");
    }
    switch (new Integer(4)) {
      case 4:
        System.out.println("boxing is OK");
    }

    // fall through when you use fall-through logic.
    int x1 = 1;
    switch (x1) {
      case 1:
        System.out.println("x is one");
      case 2:
        System.out.println("x is two");
      case 3:
        System.out.println("x is three");
    }
    System.out.println("out of the switch");

    int x2 = 7;
    switch (x2) {
      case 2:
        System.out.println("2");
      default:
        System.out.println("default");
      case 3:
        System.out.println("3");
      case 4:
        System.out.println("4");
    }
  }
}

package com.marmoush.javasamples.java6.scjpbook.chp05;

public class Loops {
  public static void main(String[] args) {
    boolean k = false;
    while (k = true) {
      System.out.println("K is now true");
      break;
    }

    for (int x3 = 10, y = 3; y < 5; y++, x3++) {
      System.out.println(x3);
    }

    int b = 3;
    for (int a = 1; b != 1; System.out.println("iterate")) {
      b = b - a;
    }
    for (int x = 0, y = 3; ((((x < 10) && (y-- > 2)) | x == 3)); x++) {
    }
    /*
     * generates unreachable code compile error in the next code after this
     * loop ------->>> for (;;) {
     * System.out.println("Inside an endless loop"); }
     */
    for (int i = 0, j = 0; (i < 10) && (j < 10); i++, j++) {
      System.out.println("i is " + i + " j is " + j);
    }
    // many mistakenly call the "increment expression," doesn't need to
    // increment or set anything;
    b = 3;
    for (int a = 1; b != 1; System.out.println("iterate")) {
      b = b - a;
    }
    // Many questions in the new (Java 6) exam list �Compilation fails� and
    // �An exception occurs at runtime� as possible answers.

    // The Enhanced for Loop (for arrays)
    int[] a = {1, 2, 3, 4};
    for (int x = 0; x < a.length; x++) // basic for loop
    {
      System.out.print(a[x]);
    }
    for (int n : a) // enhanced for loop
    {
      System.out.print(n);
    }
    int x;
    long x2;
    Long[] La = {4L, 5L, 6L};
    long[] la = {7L, 8L, 9L};
    int[][] twoDee = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    String[] sNums = {"one", "two", "three"};
    // Animal[] animals = { new Dog(), new Cat() };
    /** ***************************************************** */
    // legal 'for' declarations
    for (long y : la)
      ; // loop thru an array of longs
    for (long lp : La)
      ; // autoboxing the Long objects
    // into longs
    for (int[] n : twoDee)
      ; // loop thru the array of arrays
    for (int n2 : twoDee[2])
      ; // loop thru the 3rd sub-array
    for (String s : sNums)
      ; // loop thru the array of Strings
    for (Object o : sNums)
      ; // set an Object reference to
    // each String
    // for (Animal a : animals)
    // set an Animal reference to each
    // element

    // ILLEGAL 'for' declarations
    // for(x2 : la) ; // x2 is already declared
    // for(int x2 : twoDee) ; // can't stuff an array into an int
    // for(int x3 : la) ; // can't stuff a long into an int
    // for(Dog d : animals) ; // you might get a Cat!
    for (int i = 0; i < 10; i++) {
      System.out.println("Inside loop");
      if (Loops.doStuff()) {
        continue;
      }
      // Here is more loop code, that won't be reached when the above if
      // test is true
    }
    boolean isTrue = true;
    outer:
    for (int i = 0; i < 5; i++) {
      while (isTrue) {
        System.out.println("Hello");
        break outer;
      } // end of inner while loop
      System.out.println("Outer loop."); // Won't print
    } // end of outer for loop
    System.out.println("Good-Bye");

    outer:
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        System.out.println("Hello");
        continue outer;
      } // end of inner loop
      System.out.println("outer"); // Never prints
    }
    System.out.println("Good-Bye");
  }

  /*
   * Examples of forced exits include a break, a return, a System.exit(), or
   * an exception, which will all cause a loop to terminate abruptly, without
   * running the iteration expression. Look at the following code:
   */
  static boolean doStuff() {
    for (int x = 0; x < 3; x++) {
      System.out.println("in for loop");
      return true;
    }
    return true;
  }
}

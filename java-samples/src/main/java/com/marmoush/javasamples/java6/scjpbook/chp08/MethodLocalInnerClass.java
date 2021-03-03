package com.marmoush.javasamples.java6.scjpbook.chp08;

public class MethodLocalInnerClass {
  public static void main(String[] args) {
    MyOuter3 outer = new MyOuter3();
    outer.doStuff();
  }
}

class MyOuter3 {
  private String x = "Outer3";

  void doStuff() {
    int k = 3;
    String s = "string inside method doStuff()";
    // Important Note
    /*
     * And just a reminder about modifiers within a method: the same rules
     * apply to method-local inner classes as to local variable
     * declarations. You can't, for example, mark a method-local inner class
     * public, private, protected, static, transient, and the like. For the
     * purpose of the exam, the only modifiers you can apply to a
     * method-local inner class are abstract and final, but as always, never
     * both at the same time.
     */
    /*
     * Remember that a local class declared in a static method has access to
     * only static members of the enclosing class, since there is no
     * associated instance of the enclosing class. If you're in a static
     * method there is no this, so an inner class in a static method is
     * subject to the same restrictions as the static method. In other
     * words, no access to instance variables.
     */
    final class MyInner {
      public void seeOuter(int i, String s1) {
        System.out.println("Outer x is " + x);
        System.out.println(i);
        System.out.println(s1);
        // The next Won't Compile! unless s is final !
        // System.out.println("Local variable z is " + s);
      }
    }
    MyInner mi = new MyInner();
    mi.seeOuter(k, s);
  }
}

package com.marmoush.javasamples.java6.scjpbook.chp05;

public class Assertions {
  public static void main(String[] args) {
    Assertions assertThis = new Assertions();

    // group 1
    assertThis.methodA(1);
    assertThis.methodAB(2);

    // group 2
    assertThis.doStuff1(1, 2);
    assertThis.doStuff2(1, 2);

    /*
     * Assertions are typically enabled when an application is being tested
     * and debugged, but disabled when the application is deployed. The
     * assertions are still in the code, although ignored by the JVM, so if
     * you do have a deployed application that starts misbehaving, you can
     * always choose to enable assertions in the field for additional
     * testing.
     */

    // group 3
    assertThis.go();

    /*
     * Enabling Assertions at Runtime You enable assertions at runtime with
     *
     * java -ea com.geeksanonymous.TestClass or java -enableassertions
     * com.geeksanonymous.TestClass
     *
     * The preceding command-line switches tell the JVM to run with
     * assertions enabled.
     */

    /*
     * Disabling Assertions at Runtime You must also know the command-line
     * switches for disabling assertions,
     *
     * java -da com.geeksanonymous.TestClass or java -disableassertions
     * com.geeksanonymous.TestClass
     */

    // Selective Enabling and Disabling The command-line switches for
    // assertions can be used in various ways:
    /*
     * n With no arguments (as in the preceding examples) Enables or
     * disables assertions in all classes, except for the system classes.
     *
     * n With a package name Enables or disables assertions in the package
     * specified, and any packages below this package in the same directory
     * hierarchy (more on that in a moment).
     *
     * n With a class name Enables or disables assertions in the class
     * specified.
     */

    /*
     * You can combine switches to, say, disable assertions in a single
     * class, but keep them enabled for all others, as follows:
     *
     * java -ea -da:com.geeksanonymous.Foo
     *
     * The preceding command line tells the JVM to enable assertions in
     * general, but disable them in the class com.geeksanonymous.Foo.
     */

    /*
     * You can do the same selectivity for a package as follows:
     *
     * java -ea -da:com.geeksanonymous...
     *
     * The preceding command line tells the JVM to enable assertions in
     * general, but disable them in the package com.geeksanonymous, and all
     * of its subpackages!
     */

    /*
     * To Enable assertions in general, but disable assertions in system
     * classes:
     *
     * java -ea -dsa
     */

    /*
     * you're never supposed to handle an assertion failure. That means you
     * shouldn't catch it with a catch clause and attempt to recover.
     * Legally, however, AssertionError is a subclass of Throwable, so it
     * can be caught. But just don't do it! If you're going to try to
     * recover from something, it should be an exception. To discourage you
     * from trying to substitute an assertion for an exception, the
     * AssertionError doesn't provide access to the object that generated it
     */

    /*
     * If you see the word "appropriate" on the exam, do not mistake that
     * for "legal." "Appropriate" always refers to the way in which
     * something is supposed to be used, according to either the developers
     * of the mechanism or best practices officially embraced by Sun. If you
     * see the word �correct� in the context of assertions, as in, �Line 3
     * is a correct use of assertions,� you should also assume that correct
     * is referring to how assertions SHOULD be used rather than how they
     * legally COULD be used.
     */

    // group 4
    assertThis.doStuff4(-3);

    /*
     * Don't Use Assertions to Validate Command-Line Arguments This is
     * really just a special case of the "Do not use assertions to validate
     * arguments to a public method" rule. If your program requires
     * command-line arguments, you'll probably use the exception mechanism
     * to enforce them.
     */

    /*
     * Do Use Assertions, Even in Public Methods, to Check for Cases that
     * You Know Are Never, Ever Supposed to Happen This can include code
     * blocks that should never be reached, including the default of a
     * switch statement as follows:
     */
    int x = 1;
    int y = 3;
    switch (x) {
      case 1:
        y = 3;
        break;
      case 2:
        y = 9;
        break;
      case 3:
        y = 27;
        break;
      default:
        assert false;
        // we're never supposed to get here!
    }

    // group 5
    assertThis.doStuff();
  }

  private void methodA(int num) {
    assert (num >= 0); // throws an AssertionError
    // if this test isn't true
    System.out.println(num);
  }

  // Not only do assertions let your code stay cleaner and tighter, but
  // because assertions are inactive unless specifically "turned on"
  // (enabled), the code will run as though it were written like this:
  private void methodAB(int num) {
    System.out.println(num); // we've tested this;
    // we now know we're good here
  }

  // Really simple:
  private void doStuff1(int x, int y) {
    assert (y > x);
    // more code assuming y is greater than x
  }

  // Simple:
  private void doStuff2(int x, int y) {
    assert (y > x) : "y is " + y + " x is " + x;
    // more code assuming y is greater than x
  }

  void go() {
    int x = 1;
    boolean b = true;

    // the following six are legal assert statements
    assert (x == 1);
    assert (b);
    assert true;
    assert (x == 1) : x;
    assert (x == 1) : aReturn();
    assert (x == 1) : new Assertions();

    // the following six are ILLEGAL assert statements
    // assert(x = 1); // none of these are booleans
    // assert(x);
    // assert 0;
    // assert(x == 1) : ; // none of these return a value
    // assert(x == 1) : noReturn();
    // assert(x == 1) : ValidAssert va;
  }

  // Don't Use Assertions to Validate Arguments to a Public Method
  // The following is an inappropriate use of assertions:
  /*
   * A public method might be called from code that you don't control (or from
   * code you have never seen). Because public methods are part of your
   * interface to the outside world, you're supposed to guarantee that any
   * constraints on the arguments will be enforced by the method itself. But
   * since assertions aren't guaranteed to actually run (they're typically
   * disabled in a deployed application), the enforcement won't happen if
   * assertions aren't enabled. You don't want publicly accessible code that
   * works only conditionally, depending on whether assertions are enabled. If
   * you see the word "appropriate" on the exam, do not mistake that for
   * "legal." "Appropriate" always refers to the way in which something is
   * supposed to be used, according to either the developers of the mechanism
   * or best practices officially embraced by Sun. If you see the word
   * �correct� in the context of assertions, as in, �Line 3 is a correct use
   * of assertions,� you should also assume that correct is referring to how
   * assertions SHOULD be used rather than how they legally COULD be used.
   *
   * If you need to validate public method arguments, you'll probably use
   * exceptions to throw, say, an IllegalArgumentException if the values
   * passed to the public method are invalid.
   */
  public void doStuff4(int x) {
    assert (x > 0); // inappropriate !
    // do things with x
  }

  // Don't Use Assert Expressions that Can Cause Side Effects!
  // The following would be a very bad idea:
  public void doStuff() {
    assert (modifyThings());
    // continues on
  }

  int aReturn() {
    return 1;
  }

  public boolean modifyThings() {
    // y = x++;
    return true;
  }

  void noReturn() {}
}

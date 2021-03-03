package com.marmoush.javasamples.java6.scjpbook.chp05;

public class ExceptionHandling {
  public static void main(String[] args) {

    /*
     * Even if there is a return statement in the try block, the finally
     * block executes right after the return statement is encountered, and
     * before the return executes! This is the right place to close your
     * files, release your network sockets, and perform any other cleanup
     * your code requires.
     *
     * In fact, if you have no resources to clean up after your try block
     * completes, you probably don't need a finally clause. Also, because
     * the compiler doesn't even require catch clauses, sometimes you'll run
     * across code that has a try block immediately followed by a finally
     * block.
     */

    // The following ILLEGAL code demonstrates a try without a catch or
    // finally:
    // try {
    // do stuff
    // }
    // need a catch or finally here
    // System.out.println("out of try block");

    // You can�t sneak any code in between the try, catch, or finally
    // blocks.
    // The following won�t compile:
    // try {
    // do stuff
    // }
    // System.out.print("below the try"); //Illegal!
    // catch(Exception ex) { }

    // //////////////////////////////////////////////////////////////////////////

    /*
     * If a method doesn't provide a catch clause for a particular
     * exception, that method is said to be "ducking" the exception (or
     * "passing the buck").
     */

    /*
     * When an exception is thrown, Java will try to find (by looking at the
     * available catch clauses from the top down) a catch clause for the
     * exception type. If it doesn't find one, it will search for a handler
     * for a supertype of the exception. If it does not find a catch clause
     * that matches a supertype for the exception, then the exception is
     * propagated down the call stack. This process is called exception
     * matching
     */

    /*
     * Notice that the catch clause for the FileNotFoundException was placed
     * above the handler for the IOException. This is really important! If
     * we do it the opposite way, the program will not compile. The handlers
     * for the most specific exceptions must always be placed above those
     * for more general exceptions. The following will not compile:
     */
    // try {
    // // do risky IO things
    // } catch (IOException e) {
    // // handle general IOExceptions
    // } catch (FileNotFoundException ex) {
    // // handle just FileNotFoundException
    // }
    // You'll get a compiler error something like this:
    // TestEx.java:15: exception java.io.FileNotFoundException has
    // already been caught
    // } catch (FileNotFoundException ex) {
    // ^

    /*
     * But all non-RuntimeExceptions are considered "checked" exceptions,
     * because the compiler checks to be certain you've acknowledged that
     * "bad things could happen here." Remember this: Each method must
     * either handle all checked exceptions by supplying a catch clause or
     * list each unhandled checked exception as a thrown exception. This
     * rule is referred to as Java's "handle or declare" requirement.
     * (Sometimes called "catch or declare.")
     */

    // Unchecked exceptions (subtypes of RuntimeExceptions and Error ) are
    // legal to be thrown
    /*
     * without being specified as part of the method's public interface (and
     * a handler need not be present). And even if a method does declare a
     * RuntimeException, the calling method is under no obligation to handle
     * or declare it. RuntimeException, Error, and all of their subtypes are
     * unchecked exceptions and unchecked exceptions do not have to be
     * specified or handled.
     */
    /*
     * If you invoke a method that throws a checked exception but you don't
     * catch the checked exception somewhere, your code will not compile.
     * That's why they're called checked exceptions; the compiler checks to
     * make sure that they're handled or declared.
     */

    /*
     * Be ready to spot methods that don�t follow the �handle or declare�
     * rule, such as class MyException extends Exception { void someMethod
     * () { doStuff(); }void doStuff() throws MyException { try { throw new
     * MyException(); } catch(MyException me) { throw me; } } }
     */

    /*
     * public void doStuff() { try { // risky IO things } catch(IOException
     * ex) { // can't handle it throw ex; // Can't throw it unless you
     * declare it } }
     */
    // JVM Thrown Exceptions
    // NullPointerException:
    /*
     * class NPE { static String s; public static void main(String [] args)
     * { System.out.println(s.length()); } }
     */

    // StackOverflowError:
    /*
     * void go() { //recursion gone bad go(); }
     */

  }

  // Programmatically Thrown Exceptions
  // Created by an application and/or API developer.
  int parseInt(String s) throws NumberFormatException {
    boolean parseSuccess = false;
    int result = 0;
    // do complicated parsing
    if (!parseSuccess) // if the parsing failed
      throw new NumberFormatException();
    return result;
  }
}

package com.marmoush.javasamples.java6.scjpbook.chp06;

public class Formatting {
  public static void main(String[] args) {

    // %[arg_index$][flags][width][.precision]conversion char

    /*
     * arg_index An integer followed directly by a $, this indicates which
     * argument should be printed in this position.
     */
    /*
     * flags While many flags are available, for the exam you'll need to
     * know:
     *
     * "-" Left justify this argument
     *
     * "+" Include a sign (+ or -) with this argument
     *
     * "0" Pad this argument with zeroes
     *
     * "," Use locale-specific grouping separators (i.e., the comma in
     * 123,456)
     *
     * "(" Enclose negative numbers in parentheses
     */

    /*
     * width This value indicates the minimum number of characters to print.
     * (If you want nice even columns, you'll use this value extensively.)
     */

    /*
     * precision For the exam you'll only need this when formatting a
     * floating-point number, and in the case of floating point numbers,
     * precision indicates the number of digits to print after the decimal
     * point.
     */

    /*
     * conversion The type of argument you'll be formatting. You'll need to
     * know:
     *
     * b boolean
     *
     * c char
     *
     * d integer
     *
     * f floating point
     *
     * s string
     */

    int i1 = -123;
    int i2 = 12345;
    double i3 = 102231.333;
    System.out.printf(">>%1$(7d< \n", i1);
    System.out.printf(">>%1$,7.5f dasf< \n", i3);
    System.out.format(">>%+-7d %2$+7d< \n", i2, i1);
    System.out.printf(">>%2$b + %1$5d< \n", i1, false);
  }
}

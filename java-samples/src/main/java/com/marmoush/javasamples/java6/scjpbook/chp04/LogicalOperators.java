/*
 * Summary of Operators

The following quick reference summarizes the operators supported by the Java programming language.
Simple Assignment Operator

=	Simple assignment operator
Arithmetic Operators

+ 	Additive operator (also used for String concatenation)
- 	Subtraction operator
 *	Multiplication operator
/ 	Division operator
%	Remainder operator
Unary Operators

+ 	Unary plus operator; indicates positive value (numbers are positive without this, however)
- 	Unary minus operator; negates an expression
++  	Increment operator; increments a value by 1
--    	Decrement operator; decrements a value by 1
!     	Logical compliment operator; inverts the value of a boolean
Equality and Relational Operators

==	Equal to
!=	Not equal to
>	Greater than
>=	Greater than or equal to
<	Less than
<=	Less than or equal to
Conditional Operators

&& 	Conditional-AND
|| 	Conditional-OR
?:      Ternary (shorthand for if-then-else statement)
Type Comparison Operator

instanceof	Compares an object to a specified type
Bitwise and Bit Shift Operators

~	Unary bitwise complement
<<	Signed left shift
>>	Signed right shift
>>>	Unsigned right shift
&	Bitwise AND
^	Bitwise exclusive OR
|	Bitwise inclusive OR
 */
package com.marmoush.javasamples.java6.scjpbook.chp04;

public class LogicalOperators {

  /* @param args  */
  public static void main(String[] args) {
    byte b1 = 7 & 9;
    byte b2 = 7 | 9;
    byte b3 = 5 ^ 4;
    System.out.println(Integer.toBinaryString(7) + '&' + Integer.toBinaryString(9) + "=" + Integer.toBinaryString(b1));
    System.out.println(Integer.toBinaryString(7) + '|' + Integer.toBinaryString(9) + "=" + Integer.toBinaryString(b2));
    System.out.println(Integer.toBinaryString(5) + '^' + Integer.toBinaryString(4) + "=" + Integer.toBinaryString(b3));

    // if (5 && 6) { } --> won't compile

  }
}

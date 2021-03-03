## Language Best Practices
1. MUST NOT use "return"
2. SHOULD use immutable data structures
3. SHOULD NOT update a "var" using loops or conditions
4. SHOULD NOT define useless traits
5. MUST NOT use "var" inside a case class
6. SHOULD NOT declare abstract val or var or lazy val members
7. MUST NOT throw exceptions for validations of user input or flow control
8. MUST NOT catch Throwable
9. MUST NOT use "null"
10. MUST NOT use "Option.get"
11. MUST NOT use Java's Date or Calendar, instead use Joda-Time or JSR-310
12. SHOULD NOT use Any or AnyRef or isInstanceOf / asInstanceOf
13. MUST serialize dates as either Unix Timestamp or ISO 8601
14. MUST NOT use magic values
15. SHOULD NOT use "var" as shared state
16. Public functions SHOULD have an explicit return type
17. SHOULD NOT define case classes nested in other classes

-------------------------------

## Modular programming
http://booksites.artima.com/programming_in_scala_2ed/examples/html/ch29.html#sec6
http://www.slideshare.net/knoldus/modular-programming-using-object-in-scala-14666512

## Actors VS Future
https://www.chrisstucchio.com/blog/2013/actors_vs_futures.html

## Rules for implicit Conversion
**Marking Rule:**
Only definitions marked implicit are available.

**Scope Rule:**
An inserted implicit conversion must be in scope as a single identifier, or be associated with the source or target type of the conversion.

There’s one exception to the “single identifier” rule. The compiler will also look for implicit definitions in the companion object of the source or expected target types of the conversion.

**One-at-a-time Rule:**
Only one implicit is tried. However, it’s possible to circumvent this restriction by having implicits take implicit parameters, which will be described later in this chapter.

**Explicits-First Rule:** 
Whenever code type checks as it is written, no implicits are attempted. 

**Naming an implicit conversion**
The name of an implicit conversion matters only in two situations: 

* If you want to write it explicitly in a method application
* And for determining which implicit conversions are available at any place in the program


## First order methods and their Best practices
* Better use heads than init and last
* use isEmpty rather than  list.length==0
* if you require last element then reverse the list order
* Total complexity of reverse = (1 + n) ∗ n/2

## To trait, or not to trait?
* If the behavior will not be reused, then make it a concrete class. It is not reusable behavior after all.
* If it might be reused in multiple, unrelated classes, make it a trait. Only traits can be mixed into different parts of the class hierarchy.
* If you want to inherit from it in Java code, use an abstract class. 
* If you plan to distribute it in compiled form, and you expect outside groups to write classes inheriting from it, you might lean towards using an abstract class. The issue is that when a trait gains or loses a member, any classes that inherit from it must be recompiled.
* If efficiency is very important, lean towards using a class. 
* If you still do not know, after considering the above, then start by making it as a trait. You can always change it later, and in general using a trait keeps more options open.






### References
* https://github.com/alexandru/scala-best-practices
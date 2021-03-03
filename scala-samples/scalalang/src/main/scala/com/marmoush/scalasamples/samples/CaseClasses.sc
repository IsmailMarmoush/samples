package com.marmoush.scalasamples.samples

/*
 http://booksites.artima.com/programming_in_scala_2ed/examples/html/ch15.html
 */
object CaseClasses {

  val myTuple = (123, "abc")
  //> myTuple  : (Int, String) = (123,abc)
  val (number, string) = myTuple //> number  : Int = 123
  val exp = new BinOp("*", Number(5), Number(1))
  //> exp  : com.marmoush.scalasamples.samples.CaseClasses.BinOp = BinOp(*,Number(
  //| 5.0),Number(1.0))
  val BinOp(op, left, right) = exp //> op  : String = *
  val withDefault: Option[Int] => Int = {
    case Some(x) => x
    case None => 0
  } //> withDefault  : Option[Int] => Int = <function1>
  val second: List[Int] => Int = {
    case x :: y :: _ => y
  } //> second  : List[Int] => Int = <function1>
  //Patterns in for expression//
  val capitals =
    Map("France" -> "Paris", "Japan" -> "Tokyo") //> capitals  : scala.collection.immutable.Map[String,String] = Map(France -> P
  //| string  : String = abc
  val pi = new Number(3.14)

  def k1(expr: Expr) = expr match {
    case BinOp(op, left, right) =>
      println(expr + " is a binary operation")
    case _ =>
  } //> k1: (expr: com.marmoush.scalasamples.samples.CaseClasses.Expr)Unit
  //| left  : com.marmoush.scalasamples.samples.CaseClasses.Expr = Number(5.0)
  //| right  : com.marmoush.scalasamples.samples.CaseClasses.Expr = Number(1.0)

  //Case sequences as partial functions//
  // A sequence of cases (i.e., alternatives) in curly braces can be used anywhere a function literal can be used.

  def k2(expr: Expr) = expr match {
    case BinOp(_, _, _) => println(expr + " is a binary operation")
    case _ => println("It's something else")
  } //> k2: (expr: com.marmoush.scalasamples.samples.CaseClasses.Expr)Unit

  withDefault(Some(10)) //> res0: Int = 10

  withDefault(None)
  //> res1: Int = 0

  // If you apply such a function on a value it does not support, it will generate a run-time exception.

  def describe(x: Any) = x match {
    case 5 => "five"
    case true => "truth"
    case "hello" => "hi!"
    case Nil => "the empty list"
    case _ => "something else"
  } //> describe: (x: Any)String

  def k3(expr: Int) = expr match {
    case 0 => "zero"
    case somethingElse => "not zero: " + somethingElse
  } //> k3: (expr: Int)String
  //| aris, Japan -> Tokyo)
  for ((country, city) <- capitals) println("The capital of " + country + " is " + city)

  //> The capital of France is Paris
  //| The capital of Japan is Tokyo

  //Note//
  // If you want to use pattern matching on one of your classes, but you do not want to open access to your classes the way case classes do, then you can  use the extractors described in Chapter 26.

  // ## Types of patterns

  //Wildcard Patterns//

  def k4(E: Expr) = E match {
    case pi => "strange math? Pi = " + pi
    case _ => "OK"
  } //> k4: (E: com.marmoush.scalasamples.samples.CaseClasses.Expr)String

  //> pi  : com.marmoush.scalasamples.samples.CaseClasses.Number = Number(3.14)
  def k04(E: Expr) = E match {
    case `pi` => "strange math? Pi = " + pi
    case _ => "OK"
  } //> k04: (E: com.marmoush.scalasamples.samples.CaseClasses.Expr)String

  //Constant patterns//

  def k5(expr: Expr) = expr match {
    case BinOp("+", e, Number(0)) => println("a deep match")
    case _ =>
  } //> k5: (expr: com.marmoush.scalasamples.samples.CaseClasses.Expr)Unit

  //Variable patterns//

  //Sequence patterns//
  def k6(expr: List[Int]) = expr match {
    case List(0, _, _) => println("found it")
    case _ =>
  } //> k6: (expr: List[Int])Unit

  //Variable(case xY) or Constant(case Xyz)//
  // Simple name starting with a lowercase letter is taken to be a pattern variable; all other references are taken to be constants.

  def k06(expr: List[Int]) = expr match {
    case List(0, _*) => println("found it")
    case _ =>
  } //> k06: (expr: List[Int])Unit

  //Note about back tick//
  // The back-tick syntax for identifiers is used for two different purposes in Scala to help you code your way out of unusual circumstances. Here you see that it can be used to treat a lowercase identifier as a constant in a pattern match.

  def tupleDemo(expr: Any) =
    expr match {
      case (a, b, c) => println("matched " + a + b + c)
      case _ =>
    } //> tupleDemo: (expr: Any)Unit

  def generalSize(x: Any) = x match {
    case s: String => s.length
    case m: Map[_, _] => m.size
    case _ => -1
  } //> generalSize: (x: Any)Int

  // Earlier on, in Section 6.10, you saw that it can also be used to treat a keyword as an ordinary identifier, e.g., writing Thread.`yield`() treats yield as an identifier rather than a keyword.

  //Constructor patterns//

  def simplifyAdd01(e: Expr) = e match {
    case BinOp("+", x, x1) => BinOp("*", x, Number(2))
    case _ => e
  } //> simplifyAdd01: (e: com.marmoush.scalasamples.samples.CaseClasses.Expr)com.m

  // to do it use pattern guard
  def simplifyAdd02(e: Expr) = e match {
    case BinOp("+", x, y) if x == y =>
      BinOp("*", x, Number(2))
    case _ => e
  } //> simplifyAdd02: (e: com.marmoush.scalasamples.samples.CaseClasses.Expr)com.m

  abstract class Expr

  //Tuple Patterns//

  case class Var(name: String) extends Expr

  tupleDemo(("with a ", 3, "tuple"))

  //> matched with a 3tuple

  //Typed Patterns//

  case class Number(num: Double) extends Expr

  generalSize("abc") //> res2: Int = 3

  generalSize(Map(1 -> 'a', 2 -> 'b')) //> res3: Int = 2

  generalSize(math.Pi)

  //> res4: Int = -1

  // ## Pattern guards

  case class UnOp(operator: String, arg: Expr) extends Expr
  //| armoush.scalasamples.samples.CaseClasses.Expr

  case class BinOp(operator: String,
                   left: Expr, right: Expr) extends Expr
  //| armoush.scalasamples.samples.CaseClasses.Expr

  // other patterns
  // match only positive integers
  // case n: Int if 0 < n => ...
  // match only strings starting with the letter ‘a’
  // case s: String if s(0) == 'a' => ...

  // Pattern overlaps //
  // Patterns are tried in the order in which they are written so the order of the cases matters.
}
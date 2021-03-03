package com.marmoush.scalasamples.concepts

abstract class Tree

case class Sum(l: Tree, r: Tree) extends Tree

case class Var(n: String) extends Tree

case class Const(v: Int) extends Tree

object CaseClasses {

  def main(args: Array[String]): Unit = {

    // type Environment = (String) => Int // type alias
    def eval(t: Tree, env: (String) => Int): Int = t match {
      case Sum(l, r) => eval(l, env) + eval(r, env)
      case Var(n)    => env(n)
      case Const(v)  => v
    }

  }
}

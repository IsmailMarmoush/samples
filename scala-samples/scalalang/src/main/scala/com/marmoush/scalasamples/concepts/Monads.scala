package com.marmoush.scalasamples.concepts

object Monads extends App {
  val list = (0 to 10).toList
  println(list.map(x => x * 2))
  val x  = (y: Int) => y
  val x2 = (y: Int) => None

  //  list.flatMap(x)

}

trait hi {
  def callByName[typeA, typeB](myfunc: typeA => typeB)

  def callByName2[typeA, typeB](myfunc: (typeA, typeB) => typeB)
}

trait Functor[F[_]] {
  def fmap[A, B](f: A => B): F[A] => F[B]
}

trait Pointed[F[_]] {
  def point[A](a: => A): F[A]
}

object PointedList extends Pointed[List] {
  def point[A](a: => A) = List(a)
}

trait PointedFunctor[F[_]] {
  val functor: Functor[F]
  val pointed: Pointed[F]

  def point[A](a: => A): F[A] = pointed.point(a)

  def fmap[A, B](f: A => B): F[A] => F[B] = functor.fmap(f)
  type Market
  type Fruit
  def pricer(market: Market): Option[Fruit => Double]

}

//
//trait M[T] {
//  def map[S](f: T => S): M[S]
//
//  def flatMap[S](f: T => M[S]): M[S]
//}
//
//class MyMonad(x:List[String]) extends M[String]{
//
//  override def map[S](f: (String) => S): M[S] =x.map(f)
//
//  override def flatMap[S](f: (String) => M[S]): M[S] = ???
//}

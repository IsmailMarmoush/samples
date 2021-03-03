trait A {
  val foo: Int
  val bar = 10
  println("In A: foo: " + foo + ", bar: " + bar)
}
class B extends A {
  val foo: Int = 25
  println("In B: foo: " + foo + ", bar: " + bar)
}
class C extends B {
  override val bar = 99
  println("In C: foo: " + foo + ", bar: " + bar)
}

// new A{val foo=10};

new C();
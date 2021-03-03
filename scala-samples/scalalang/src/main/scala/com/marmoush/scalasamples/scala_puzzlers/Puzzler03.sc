trait A {
  val audience: String
  println("Hello " + audience)
}

class BMember(a: String = "World") extends A {
  val audience = a
  println("I repeat: Hello " + audience)
}

class BConstructor(val audience: String = "World") extends A {
  println("I repeat: Hello " + audience)
}

val m=new BMember("Readers")

val m2=new BConstructor("Readers")
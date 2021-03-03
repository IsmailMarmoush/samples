// Puzzler 01
List(1, 2).map { i => println("Hi"); i + 1 }

List(1, 2).map {
  println("Hi");
  _ + 1
}
println("####################################################################")

val regularFunc = { a: String => println("foo"); println(a); "baz" }
val m=regularFunc("hello")

println(m)

println("####################################################################")

val one = {
  println("foo")
  println(_: Any);
  "baz"
}

val two = {
  println("foo");
  { a: Any => println(a) };
  "baz"
}

println("####################################################################")

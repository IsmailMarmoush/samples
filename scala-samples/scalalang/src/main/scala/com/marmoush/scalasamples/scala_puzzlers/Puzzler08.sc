val xs = Seq(Seq("a", "b", "c"), Seq("d", "e", "f"),
  Seq("g", "h"), Seq("i", "j", "k"))

val ys = for (Seq(x, y, z) <- xs) yield x + y + z

val zs = xs map { case Seq(x, y, z) => x + y + z }
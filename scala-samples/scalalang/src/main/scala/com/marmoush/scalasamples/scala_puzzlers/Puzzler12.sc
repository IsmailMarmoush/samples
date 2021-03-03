case class RomanNumeral(symbol: String, value: Int)

implicit object RomanOrdering extends Ordering[RomanNumeral] {
  def compare(a: RomanNumeral, b: RomanNumeral) =
    a.value compare b.value
}

import scala.collection.immutable.SortedSet

val numerals = SortedSet(
  RomanNumeral("M", 1000),
  RomanNumeral("C", 100),
  RomanNumeral("X", 10),
  RomanNumeral("I", 1),
  RomanNumeral("D", 500),
  RomanNumeral("L", 50),
  RomanNumeral("V", 5)
)
println("Roman numeral symbols for 1 5 10 50 100 500 1000:")

for (num <- numerals; sym = num.symbol) {
  print(s"${sym} ")
}
numerals map {
  _.symbol
} foreach { sym => print(s"${sym} ") }
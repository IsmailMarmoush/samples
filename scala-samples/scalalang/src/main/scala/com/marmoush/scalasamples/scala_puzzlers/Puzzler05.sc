def sumSizes(collections: Iterable[Iterable[_]]): Int =
  collections.map(_.size).sum
sumSizes(List(Set(1, 2), List(3, 4)))
sumSizes(Set(List(1, 2), Set(3, 4)))

Set(List(1, 2), Set(3, 4,5)).map(_.size)

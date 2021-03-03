# Scala Testing

**Triple equal in ScalaTest library**
ScalaTest lets you use Scala's assertion syntax, but defines a triple equals operator (===) to give you better error messages. The following code would give you an error indicating only that an assertion failed:
`assert(1 == 2)`
Using triple equals instead would give you the more informative error message, "1 did not equal 2":
`assert(1 === 2)`

**expect() method**
expect(2) {
	ele.width
}

**intercept**
expects a defined exception to be thrown
```
intercept[IllegalArgumentException] {
elem('x', -2, 3)
}
```

## Behavioral driven development test
```
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import Element.elem
class ElementSpec extends FlatSpec with ShouldMatchers {
"A UniformElement" should
"have a width equal to the passed value" in {
val ele = elem('x', 2, 3)
ele.width should be (2)
}
it should "have a height equal to the passed value" in {
val ele = elem('x', 2, 3)
ele.height should be (3)
}
it should "throw an IAE if passed a negative width" in {
evaluating {
elem('x', -2, 3)
} should produce [IllegalArgumentException]
}
}

import org.specs._
import Element.elem
object ElementSpecification extends Specification {
"A UniformElement" should {
"have a width equal to the passed value" in {
val ele = elem('x', 2, 3)
ele.width must be_==(2)
}
"have a height equal to the passed value" in {
val ele = elem('x', 2, 3)
ele.height must be_==(3)
}
"throw an IAE if passed a negative width" in {
elem('x', -2, 3) must
throwA[IllegalArgumentException]
}
}
}

```

## Property based test
>The ==> symbol is a ScalaCheck implication operator. It implies that whenever the left hand expression is true, the expression on the right must hold true. Thus in this case, the expression on the right of ==> must hold true whenever w is greater than 0.

```
import org.scalatest.WordSpec
import org.scalatest.prop.Checkers
import org.scalacheck.Prop._
import Element.elem
class ElementSpec extends WordSpec with Checkers {
	"elem result" must {
		"have passed width" in {
			check((w: Int) => w > 0 ==> (elem('x', w, 3).width == w))
		}
		"have passed height" in {
			check((h: Int) => h > 0 ==> (elem('x', 2, h).height == h))
		}
	}
}
```


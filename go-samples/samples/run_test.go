package samples

import (
	"fmt"
	"math"
	"testing"
)

func TestHelloZero(*testing.T) {
	// Hello()
	//WordCount("hello hi hello this is is is mail")
	//testVertexMethod()
	nonStructMethod()
}

// ---------------------------
//
//func testVertexMethod() {
//	v := Vertex{3, 4}
//	fmt.Println(v.Abs())
//}

// ---------------------------
type MyFloat float64

func (f MyFloat) Abs() float64 {
	if f < 0 {
		return float64(-f)
	}
	return float64(f)
}
func nonStructMethod() {
	f := MyFloat(-math.Sqrt2)
	fmt.Println(f.Abs())
}

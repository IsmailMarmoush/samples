package samples

import (
	"fmt"
	"math"
	"strings"
)

// hello
type Verdtex struct {
	X int
	// i = 10
	Y int
}

// hello
// bye
func Hello() {
	fmt.Printf("hello, world\n")

	const k = 2
	tiles := [3]int{}
	for i := range tiles {
		print(i)
	}

	fmt.Print(k)
}

func WordCount(s string) map[string]int {
	m := make(map[string]int)
	var words []string = strings.Split(s, " ")
	for i := range words {
		if v, ok := m[words[i]]; ok {
			m[words[i]] = v + 1
		} else {
			m[words[i]] = 1
		}
	}
	return m
}

func adder() func(int) int {
	sum := 0
	return func(x int) int {
		print(sum, "+", x, "=")
		sum += x
		print(sum)
		println()
		return sum
	}
}

type Edge struct {
	X, Y float64
}

type Vertex struct {
	X, Y float64
}

func (v Vertex) Abs() float64 {
	return math.Sqrt(v.X*v.X + v.Y*v.Y)
}

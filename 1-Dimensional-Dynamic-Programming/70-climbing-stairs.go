package main

import (
	"fmt"
	"strconv"
)

func climbStairs(n int) int {
	if n == 1 {
		return 1
	}
	stairs := make([]int, n+1)
	stairs[1] = 1
	stairs[2] = 2

	for i := 3; i <= n; i++ {
		stairs[i] = stairs[i-1] + stairs[i-2]
	}

	return stairs[n]
}

func main() {
	fmt.Println("Answer: " + strconv.Itoa(climbStairs(5)))
}

package main

import (
	"fmt"
	"time"
)

func sayHello(name string) {
	fmt.Printf("Hello word %s!", name)
}

func main() {
	sayHello("Paulo")

	go sayHello("Paulo Vinicius")

	go func(msg string) {
		fmt.Println(msg)
	}("next")

	time.Sleep(time.Second)
	fmt.Println("done")
}

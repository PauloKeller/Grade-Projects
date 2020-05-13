package main

// #include <stdlib.h>
// #include "wrapper.c"
import "C"
import (
	"fmt"
	"unsafe"
)

func read(filename string) string {
	f := C.CString(filename)
	defer C.free(unsafe.Pointer(f))
	s := C.my_shm_read(f)
	defer C.free(unsafe.Pointer(s))
	return C.GoString(s)
}

func main() {
	fmt.Println(read("/tmp"))
}

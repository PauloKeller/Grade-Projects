package main

import (
	"io"
	"net/http"

	"github.com/rs/cors"
)

func hello(res http.ResponseWriter, req *http.Request) {
	io.WriteString(res, "Hello paulo")
}

func main() {
	mux := http.NewServeMux()
	mux.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Content-Type", "application/json")
		w.Write([]byte("{\"hello\": \"Paulo\"}"))
	})

	handler := cors.Default().Handler(mux)
	http.ListenAndServe(":5000", handler)
}

package main

import (
	"encoding/json"
	"io"
	"math/rand"
	"net/http"

	"github.com/rs/cors"
)

type Temperature struct {
	Value int `json:"temperature"`
}

func hello(res http.ResponseWriter, req *http.Request) {
	io.WriteString(res, "Hello paulo")
}

func main() {
	mux := http.NewServeMux()
	mux.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		v := rand.Intn(33)
		t := &Temperature{
			Value: v,
		}

		w.Header().Set("Content-Type", "application/json")
		json.NewEncoder(w).Encode(t)
	})

	handler := cors.Default().Handler(mux)
	http.ListenAndServe(":5001", handler)
}

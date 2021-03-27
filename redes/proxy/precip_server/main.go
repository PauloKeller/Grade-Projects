package main

import (
	"encoding/json"
	"fmt"
	"io"
	"math/rand"
	"net/http"
	"strconv"

	"github.com/gorilla/mux"

	"github.com/rs/cors"
)

type Precip struct {
	PrecipChance int    `json:"precipChance"`
	Type         string `json:"type"`
}

func hello(res http.ResponseWriter, req *http.Request) {
	io.WriteString(res, "Hello paulo")
}

func main() {
	router := mux.NewRouter()
	router.HandleFunc("/{temp}", func(w http.ResponseWriter, r *http.Request) {
		params := mux.Vars(r)
		v := params["temp"]
		temp, err := strconv.Atoi(v)

		if err != nil {
			temp = 23
		}

		precipType := "rain"

		isCold := temp < 0
		isWarm := temp > 25

		if isCold {
			fmt.Println("cold weather detected")
			precipType = "snow"
		}

		if isWarm {
			print("warm weather detected")
			precipType = "storms"
		}

		percentChance := rand.Intn(34)

		p := &Precip{
			PrecipChance: percentChance,
			Type:         precipType,
		}

		w.Header().Set("Content-Type", "application/json")
		json.NewEncoder(w).Encode(p)
	})

	handler := cors.Default().Handler(router)
	http.ListenAndServe(":5002", handler)
}

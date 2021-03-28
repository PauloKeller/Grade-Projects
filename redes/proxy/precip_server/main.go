package main

import (
	"encoding/json"
	"fmt"
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

func main() {
	router := mux.NewRouter()
	router.HandleFunc("/", func(w http.ResponseWriter, r *http.Request) {
		key := r.FormValue("temp")
		temp, err := strconv.Atoi(key)

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
	http.ListenAndServe("0.0.0.0:5002", handler)
}

<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png" />
    <div>
      <input v-model="base" placeholder="base" id="base-input" />
      <input v-model="logNumber" placeholder="log number" id="log-number-input" />
      <p id="result-label">{{ result }}</p>
      <div>
        <button @click="executeOperation" id="submit-button">Submit</button>
      </div>
    </div>
  </div>
</template>

<script>
import { customLog } from "./provider/calculatorProvider";

export default {
  name: "App",
  data() {
    return {
      base: null,
      logNumber: null,
      result: null,
    };
  },
  methods: {
    async executeOperation() {
      let data = { base: this.base, logNumber: this.logNumber };
      let response = await customLog(data);
      this.result = response.result;
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

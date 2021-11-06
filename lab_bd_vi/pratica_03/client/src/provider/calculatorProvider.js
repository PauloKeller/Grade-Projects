import axios from "axios";

async function customLog({ base, logNumber }) {
  let model = {
    base,
    logNumber,
  };

  let result = await axios.post("http://localhost:8080/calculator", model);
  return result.data;
}

export { customLog };

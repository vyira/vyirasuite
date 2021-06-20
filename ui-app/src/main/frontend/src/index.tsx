import React from "react";
import ReactDOM from "react-dom";
import App from "App";
import { BackgroundAnimation } from "./components/BackgroundAnimation";
import { Provider } from "react-redux";
import store from "redux/store";

ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <App />
    </Provider>
  </React.StrictMode>,
  document.getElementById("root")
);

ReactDOM.render(<BackgroundAnimation />, document.getElementById("bg"));

import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {BackgroundAnimation} from "./components/BackgroundAnimation";

ReactDOM.render(
    <React.StrictMode>
        <App/>
    </React.StrictMode>,
    document.getElementById('root')
);

ReactDOM.render(<BackgroundAnimation/>, document.getElementById("bg"));
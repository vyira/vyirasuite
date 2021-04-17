import React from 'react';
import './App.scss';
import {BackgroundAnimation} from "./components/BackgroundAnimation";
import {Ball} from "./components/BackgroundAnimation/Ball";


function App() {
    return (
        <BackgroundAnimation>
            <div className="App">
                <Ball index={1}/>
            </div>
        </BackgroundAnimation>
    );
}

export default App;

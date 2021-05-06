import React from 'react';
import './App.scss';
import QuestionCard from "./components/quiz/QuestionCard";


function App() {
    return (
        <div className="App">
            <h1>Welcome to Quiz Server</h1>
            <QuestionCard questionId={'someID'}/>
        </div>
    );
}

export default App;

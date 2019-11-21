import React from 'react';
import './App.css';

function App() {
    const name = 'React';
    return (
        <>
            {/*태그 외부의 주석*/}
            <div
                className="react" //태그 내부의 주석
            >
                {name}
            </div>
            <input />
        </>
    );
}

export default App;
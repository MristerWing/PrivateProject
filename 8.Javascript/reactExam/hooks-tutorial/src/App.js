import React from "react";
import Counter from "./Counter/Counter";
//import Info from './Info/Info';

function App() {
    return <Counter />;
}

export default App;

/* const [visible, setVisible] = useState(false);
    return (
        <div>
            <button onClick={() => setVisible(!visible)}>
                {visible ? "숨기기" : "보이기"}
            </button>
            <hr />
            {visible && <Info />}
        </div>
    ); */

import React from 'react';
//import Average from './average/Average';
import Info from './info/Info-reducer';

function App() {
	return <Info />;
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

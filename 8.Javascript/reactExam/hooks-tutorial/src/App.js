import React, { useState } from 'react';
//import Counter from "./Counter/Counter";
import Info from './info/Info';

function App() {
	//return <Counter />;

	const [visible, setVisible] = useState(false);
	return (
		<div>
			<button onClick={() => setVisible(!visible)}>
				{visible ? '숨기기' : '보이기'}
			</button>
			<hr />
			{visible && <Info />}
		</div>
	);
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

/* import React from "react";

const App = () => {
    //return <MyComponent name={'React'} favoriteNumber={1}>리액트</MyComponent>;
    //return <Counter></Counter>;
    //return <Say />;
    //return <EventPractice />
    //return <ValidationSample />;
};

export default App; */

import React, { Component } from "react";
import LifeCycleSample from "./LifeSycleSample/LifeSycleSample";
import ErrorBoundary from "./ErrorBoundary/ErrorBoundary";

function getRandomColor() {
    return "#" + Math.floor(Math.random() * 16777215).toString(16);
}

class AppComponent extends Component {
    state = {
        color: "000000"
    };

    handleClick = () => {
        this.setState({
            color: getRandomColor()
        });
    };

    render() {
        return (
            <div>
                <button onClick={this.handleClick}>랜덤 색상</button>
                <ErrorBoundary>
                    <LifeCycleSample color={this.state.color} />
                </ErrorBoundary>
            </div>
        );
    }
}

export default AppComponent;

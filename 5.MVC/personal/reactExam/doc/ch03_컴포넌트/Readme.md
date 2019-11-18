# 컴포넌트

1. 컴포넌트는 클래스형 컴포넌트와 함수형 컴포넌트로 나누어진다.
2. 컴포넌트는 모듈을 불러오기(import)와 내보내기(export)를 수행할 수 있다.

### props

1. 컴포넌트는 props(properties의 줄인말)로 속성을 설정한다. `props`는 해당 컴포넌트를 불러와 사용하는 부모 컴포넌트에서 설정이 가능하다.
2. `props`는 입력된 value값으로 설정하거나 `defaultProps`를 이용하여 기본 `props`를 설정하거나 `propTypes` 를 사용하여 `props`를 검증할 수 있다.

### state

1. 리액트에서 `state`는 컴포넌트 내부에서 바뀔 수 있는 값을 의미한다.
2. `props`와 다른점은 컴포넌트가 사용되는 과정에서 부모 컴포넌트가 설정하는 값이여서 해당 `props`를 읽기전용으로만 사용할 수 있어 `props`를 부모 컴포넌트에서 바꾸어줘야한다는 점이 다르다.
3. `state`는 반드시 `setState()` 혹은 `useState()`를 통해 전달받은 세터 함수를 사용하여 값을 변경해야한다.
4. 또한 `state`는 불변성을 유지해야한다.

---

### 클래스형 컴포넌트

1. 클래스형 컴포넌트는 함수형 컴포넌트와 기본적으로는 동일하나, `state`와 라이프사이클을 사용할 수 있다는 점이 다르다.
2. 클래스형 컴포넌트는 반드시 `render()`함수가 존재해야 하며, 그안에 보여주어야 할 jsx를 반환해야 한다.
3. 클래스형 컴포넌트에서 props값을 사용할 때에는 `this,props`라고 사용하여 조회한다.
4. 클래스형 컴포넌트에서 `state`는 `constructor`에서 선언하거나 `state = {}`를 이용하여 초기화해준다.
5. state의 값을 변경해주어야 할 경우 `setSate()`를 이용하여 값을 변경한다.

-   클래스형 컴포넌트는 다음과 같이 선언한다.

```
import React, { Component } from 'react';
import './App.css';

class App extends Component {
    render() {
        const name = 'React';
        return <div className="react">{name}</div>
    }
}

export default App;
```

### 함수형 컴포넌트

1. 함수형 컴포넌트는 클래스형 컴포넌트보다 선언하기 훨씬 간편하게 이루어져 있다.
2. 메모리 자원과 용량 또한 더 적게 차지한다.
3. 함수형 컴포넌트는 `state`와 라이프사이클 API의 사용이 불가능하다는 단점이 있었으나, 16.8버전이후 Hooks의 추가로 개선되었다.

-   함수형 컴포넌트는 다음과 같이 선언한다.

```
import React from 'react';
import MyComponent from './MyComponent';

const App = () => {
    return <MyComponent />;
};

export default App;
```

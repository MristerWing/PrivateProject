# Hooks

Hooks는 React v16.8에서 새로 도입된 기능으로 함수형 컴포넌트에서도 상태 관리를 할 수 있는 `useState`, 렌더링 직후 작업을 설정하는 `useEffect`등의 기능을 제공하여 기존의 함수형 컴포넌트에서 할 수 없었던 다양한 작업을 할 수 있게 해준다.

### useState

1. `useState`는 가장 기본적인 Hook이며, 함수형 컴포넌트에서도 가변적인 상태를 가질 수 있게 해준다.
2. 사용시에는 React를 `import`할 때 `useState`사용을 명시하여 사용한다.(`import React, { useState } from 'react';`)
3. `useState`는 하나의 상태 값만 관리 할 수 있으므로 관리해야할 상태가 여러개 라면 `useState`를 여러번 사용한다.

### useEffect

1. `useEffect`는 리액트 컴포넌트가 렌더링 될 때마다 특정 작업을 수행하도록 설정할 수 있는 Hook을 의미한다.
2. 클래스형 컴포넌트의 `compoentDidMount`와 c`omponentDidUpdate`를 합친상태와 유사하다.

[show code](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hooks-tutorial/src/info/Info.js)

### useReducer

1. `useReducer`는 `useState`보다 더 다양한 컴포넌트 상황에 따라 다양한 상태를 다른 값으로 업데이트 해 주고 싶을 때 사용하는 Hook이다.
2. Reducer는 현재상태, 그리고 업데이트를 위해 필요한 정보를 담은 `Action`값을 전달받아 새로운 상태를 반환하는 함수 이다. `Reducer`함수의 새로운 상태를 만들 때에는 반드시 불변성을 유지해야 한다.
3. `useReducer()`함수는 2개의 인자를 가지며 첫번째는 `reducer`함수, 두번째는 해당 리듀서의 기본값을 가진다.

[show code(counter)](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hooks-tutorial/src/Counter/Counter.js)
[show code(info)](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hooks-tutorial/src/info/Info-reducer.js)

### useMemo

1. `useMemo`함수는 컴포넌트 내부에서 발생하는 연산을 최적화 하기 위하여 사용한다.
2. `useState`는 상태의 변화를 전부 확인하므로 `state`의 상태가 변할때마다 호출된다. 하지만 `useMemo`는 렌더링 과정에서 특정 값이 바뀔때만 연산을 실행하고, `state`가 변하지 않았으면 이전에 연산했던 결과를 다시 사용한다.

### useCallback

1. `useCallback`또한 `useMemo`와 같이 렌더링 성능을 최적화 하는데에 사용된다.
2. 이벤트 핸들러 함수를 필요한 때에만 생성할 수 있다.
3. 리액트 컴포넌트 내에서 함수를 언한다면 컴포넌트가 리렌더링 될 때마다 함수들이 새로 생성된다. 그러므로 컴포넌트의 렌더링이 자주 발생할 경우, 이부분을 최적화 해주어야 한다.
4. `useCallback`의 첫번째 인자는 생성하고 싶은 함수를 넣고, 두번째 인자는 베열을 넣는다. 이 배열에는 어떤 값이 바뀌었을 때 함수를 새로 생성해야 하는지를 명시한다.
5. 두번째 인자의 배열의 값이 비어있을 경우, 렌더링될 때 단 한번만 함수가 생성되며, 배열에 값이 존재한다면, 인풋의 내용이 바뀌거나 새로운 항목이 추가될 때마다 함수가 생성된다.
6. 이를 결정하는 방법은 함수내부의 상태값에 의존해야 하는 경우를 확인한다. 이와 같은 경우 반드시 두번째 인자에 의존해야 하는 값을 포함시켜 주어야 한다.
7. **숫자, 문자열 객체러럼 일반변수를 재사용해야할 경우 `useMemo`를 사용하며, 함수를 재사용해야할 경우 `useCallback`을 사용한다.**

-   ex

```javascript
useCallback(() => {
	console.log('hello callback!!');
}, []);

useMemo(() => {
	const fn = () => {
		console.log('hello memo!!');
	};
	return fn;
}, []);
```

### useRef

1. `useRef`는 함수형 컴포넌트에서 ref를 쉽게 사용할 수 있게 해주는 Hook이다.
2. `useRef`는 추가로 로컬변수(렌더링과 상관없이 바뀔 수 있는 값)를 사용해야 할 때에도 사용할 수 있다.

[show code](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hooks-tutorial/src/average/Average.js)

### 커스텀 Hooks

1. 여러 컴포넌트에서 기능을 공유할 경우, 이를 Hook으로 작성하여 로직을 재사용할 수 있다.(모듈화)

[show code](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hooks-tutorial/src/info/userInput.js)

### 다른 Hooks

-   다른 개발자들이 개발한 Hooks또한 라이브러리처럼 설치하여 사용할 수 있다.
    > Link1: https://nikrgraf.github.io/react-hooks/  
    > Link2: https://github.com/rehooks/awesome-react-hooks

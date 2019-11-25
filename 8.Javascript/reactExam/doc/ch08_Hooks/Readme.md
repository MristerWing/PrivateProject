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

[show code](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hooks-tutorial/src/Counter/Counter.js)

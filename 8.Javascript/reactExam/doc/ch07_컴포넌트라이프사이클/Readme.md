# 컴포넌트 라이프사이클

1. 모든 리액트의 컴포넌트에는 라이프사이클(수명주기)가 존재한다.
2. 컴포넌트를 처음 랜더링 할때 작업을 처리하거나 업데이트 전후에 작업을 처리해야할 때 컴포넌트의 라이프사이클 메서드를 사용한다.
3. 컴포넌트 라이프 사이클은 클래스형 컴포넌트에서만 사용이 가능하다.
4. 라이프사이클의 메서드 종류는 총 아홉가지이다.
5. Will접두사가 붙으면 작업을 작동하기 전에 실행되는 메서드이고, Did가 붙으면 작동한 후 실행되는 메서드이다.
6. 라이프사이클 메서드는 Override하여 작동시킨다.
7. 라이프사이클은 마운트, 업데이트, 언마운트 카테고리로 나누어서 구분한다.
    1. 마운트: 페이지에 컴포넌트가 나올 때
    2. 업데이트: 컴포넌트의 정보를 업데이트할 때
    3. 언마운트: 페이지에서 컴포넌트가 사라질 때

---

### 마운트

-   **마운트의 메서드 호출순서**  
    `Create Component` => `constructor` => `getDerivedStateFromProps` => `render` => `componentDidMount`
    1. constructor: 컴포넌츠를 새로 만들 때마다 호출되는 메서드
    2. getDerivedStateFromProps: `props`에 있는 값을 `state`에 넣을 때 사용되는 메서드
    3. render: 제작한 UI를 렌더링하는 메서드
    4. componentDidMount: 컴포넌트가 웹 브라우저상에 나타난 후 호출되는 메서드

### 업데이트

-   업데이트의 조건

    1. `props`가 바뀔 때
    2. `state`가 바뀔 때
    3. 부모 컴포넌트가 리 렌더링 될때
    4. this.forUpdate로 강제로 렌더링을 트리거할 때

-   **업데이트의 메서드 호출 순서**  
    업데이트 발생 => `getDerivedStateFromProps` => `shouldComponentUpdate` => (if true) `render` => `getSnapshotBeforeUpdate`(웹 브라우저상의 실제
    DOM변화) => `componentDidUpdate`
    1. getDerivedStateFromProps: 마운트과정에서도 호출되는 메소드로서, 업데이트가 시작하기 전에도 호출된다. `props`의 변화에 따라 `state` 값에도 변화를 주고 싶을 때 사용한다.
    2. shouldComponentUpdate: 컴포넌트가 리렌더링을 해야 할지 말아야 할지를 결정하는 메서드이다. 이 메서드에서 `true` or `false`값을 반환해야 하며, `true`면 다음 라이프사이클을 계속 실행하고 `false`면 작업을 중지한다. 만약 특정 함수에서 `this.forceUpdate()`함수를 호출한다면 이 과정을 생략하고 바로 `render`를 호출한다.
    3. render: 컴포넌트를 리 렌더링
    4. getSnapshotBeforeUpdate: 컴포넌트 변화를 DOM에 반영하기 바로 직전에 호출되는 함수
    5. componentDidUpdate: 컴포넌트의 업데이트 작업이 끝난 후 호출하는 메서드

### 언마운트

-   마운트의 반대과정으로, 컴포넌트를 DOM에서 제거하는 것을 의미한다.
-   **언마운트의 호출 순서**  
    언마운트 => `compenentWillUnmount`
    1. componentWillUnmount: 컴포넌트가 웹 브라우저상에서 사라지기 전에 호출하는 메서드

[show code(life cycle)](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hello-react/src/LifeSycleSample/LifeSycleSample.js)  
[show code(error boundary)](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hello-react/src/ErrorBoundary/ErrorBoundary.js)

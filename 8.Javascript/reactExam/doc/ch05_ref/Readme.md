# ref(reference)

1. 일반적인 HTML의 DOM요소에 이름을 달때 `id`값을 사용하듯이 리액트 프로젝트 내부에서 DOM에 이름을 다는 것을 `ref`라고 한다.
2. 컴포넌트 안에서 `id`를 사용 할 수는 있으나, `id`의 값은 유일(unique)해야 하는데
   전역으로 작성되면 중복된 id값이 발생할 수 있다. 하지만 `ref`는 컴포넌트 내부에만 작동 하므로 문제가 생기지 않는다.
3. `ref`는 DOM에 반드시 접근해야 하는 경우에 사용하는데 이는 다음과 같다.
    1. 특정 `input`에 포커스 주기
    2. 스클롤 박스 조작하기
    3. Canvas요소에 그림 그리기
    4. 등등
4. react에서 `ref`를 사용하는 방법은 다음과 같다.
    1. 콜백 함수를 통한 `ref`설정
    2. `createRef`를 통한 `ref`설정
    3. 함수형 컴포넌트의 Hook인 `useRef`
5. `ref`는 리액트 컴포넌트에도 활용이 가능하다. 이때 ref로 접근한 컴포넌트의 내부함수 또한 사용할 수 있다.

### ref 사용

**1. 콜백 함수를 통한 ref설정**

`ref`를 달고자 하는 요소에 `ref`라는 콜백 함수를 `props`로 전달해 주면 되는 방법으로 다음과 같이 작성한다.

`<input ref={ref => this.input = ref} />`

이후 `this.input`은 `input`요소의 DOM을 가르킨다.

**2. createRef를 통한 ref설정**

리액트에 내장되어 있는 `createRef`라는 함수를 이용하여 `ref`를 설정 할수도 있다.
이 함수는 리액트 v16.3부터 도입되었다. 다음과 같이 작성한다.

```javascript
impot React, { Component } from 'react';

class Ref extends Component {
    input = React.createRef();

    handleFocus = () => {
        this.input.current.focus();
    }

    render() {
        return(
            <div>
                <input ref={this.input} />
            </div>
        );
    }
}

export default Ref
```

[show code(Validation)](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hello-react/src/ValidationSample/ValidationSample.js)  
[show code(ScrollBox)](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hello-react/src/ScrollBox/ScrollBox.js)

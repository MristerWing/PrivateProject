# 컴포넌트 반복

1. 컴포넌트의 요소가 반복되어야 할 경우, 배열로 반복할 요소를 작성하여 컴포넌트 값을 작성하여 준다.
2. 이때, 단순히 배열 값만을 작성하는 것이 아니라 요소에 key값을 할당해주어야 한다.
    - 예 `<li key={key}>{value}</li>`
3. `state`나 `useState`를 응용할경우, 동적배열를 사용하여 DOM의 요소가 계속해서 변화하는 환경 또한 구현할 수 있다.
4. 이때 배열을 변경 할 때에는 직접 접근하여 수정하는 것이 아니라 `concat`이나 `filter`등의 내장 함수를 이용하여 새로운 배열을 만든 후 이를 새로운 상태로 설정해주어야 한다. 이는 react의 객체불변성을 유지시켜 주기 위함이다.

[show code](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/hello-react/src/iterationSample/IterationSample.js)

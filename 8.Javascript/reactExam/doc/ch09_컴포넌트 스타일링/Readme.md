# 컴포넌트 스타일링

1. 리액트에서는 컴포넌트를 스타일링 할때 다양한 방식을 사용할 수 있다.
2. 방식중에 정해진 서식은 없으며 원하는 방식을 사용하면 된다.
    1. 일반 CSS
    2. Sass: 자주 사용되는 CSS전처리기중하나로 확장된CSS 문법을 사용하여 CSS코드를 쉽게 작성 할 수 있도록 한다.
    3. CSS Module: 스타일을 작성할 때 CSS 클래스가 다른 CSS 클래스의 이름과 절대 충돌하지 않도록 파일마다 고유한 이름을 자동으로 생성해 주는 옵션이다.
    4. styled-commponents: 스타일을 자바스크립트 파일에 내장시키는 방식으로 스타일을 작성함과 동시에 해당 스타일이 적용된 컴포넌트를 만들 수 있게 해준다.

### 일반적인 CSS

1. 웹에서 사용하는 가장 일반적인 방식으로 CSS파일과 JSX파일을 분리하여 관리한다.
2. CSS를 작성 할 때는 BEM네이밍이나 CSS Selector방식을 따른다.

-   CSS Select

```CSS
.APP .logo {
    animation: App-logo-spin infinite 20s linear;
    height: 40vmin;
}
```

> BEM네이밍 방식: https://medium.com/witinweb/css-%EB%B0%A9%EB%B2%95%EB%A1%A0-1-bem-block-element-modifier-1c03034e65a1

### Sass

1. Sass란 Syntactically Awsome Style Sheets(문법적으로 매우 멋진 스타일시트)란 의미이다.
2. Sass는 CSS전처리기로 복잡한 작업을 쉽게 할 수 있도록 해준다. 또한 스타일 코드의 재활용성을 높혀주며, 코드의 가동성을 높혀 유지보수를 더욱 쉽게 해준다.
3. Sass는 .scss 와 .sass를 지원한다. 그리고 이 둘의 문법적 차이는 꾀 다르다.
4. 다른 .scss파일을 불러올 때에는 `@import`구문을 사용한다.
5. `yarn-eject`명령어를 이용하면 sass-loader의 설정을 커스터마이징하여 사용할 수 있다.
    > [code(Find sassRegex)](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/styling-react/src/config/webpack.config.js)
6. node_modules에 설치된 라이브러리는 ~library/로 축약할 수 있다.

-   .sass

```CSS
$font-stack: Helvetica, sans-serif
$primary-color: #333

body
    font: 100% $font-stack
    color: $primary-color
```

-   .scss

```CSS
$font-stack: Helvetica, sans-serif;
$primary-color: #333;

body {
    font: 100% $font-stack;
    color: $primary-color;
}
```

[show code(info)](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/styling-react/src/sass)

### CSS Module

1. CSS모듈은 CSS를 불러와서 사용할 때 클래스 이름을 고유한 값, 즉 [파일 이름]\_[클래스이름]\_\_[해시값] 형태로 자동으로 만들어서 컴포넌트 스타일 클래스 이름이 중첩되는 현상을 방지하는 기술이다.
2. CSS모듈은 사용자가 직접 불러온 컴포넌트 내에서만 작동하기 때문에 중복성에 대한 고민을 하지않아도 된다.
3. 특정 클래스가 전역으로 사용될 경우, 앞에 `:global`을 붙여서 글로벌 CSS임을 명시해줄 수 있다.

[show code(css)](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/styling-react/src/CSSModule.module.css)
[show code(scss)](https://github.com/MristerWing/PrivateProject/blob/master/8.Javascript/reactExam/styling-react/src/CSSModule.module.scss)

### CSS-in-JS

1. CSS-in-JS는 자바스크립트는 파일 안에 스타일을 선언하는 방식을 의미한다.
2. 이것은 관련된 라이브러리가 많으며 대표적인 예는 styled-domponents 와 emotion이 있다.

#### styled-component

1. CSS-in-JS의 라이브러리 중 하나로 js내에서 css를 바로 사용할 수 있게 도와주는 라이브러리이다.
2. Tagged 탬플릿 리터럴을 이용하여 작성하며, 백틱을 사용하여 작성한다.
3. styled-component의 사용법은 styled를 불러온뒤, `styled.태그명`으로 사용한다.
4. 단순 변수가 아니라 여러 줄의 스타일 구문을 조건부로 설정해야 하는 경우, CSS를 불러와야한다.

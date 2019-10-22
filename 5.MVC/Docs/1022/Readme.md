10/22
===

### Cookie & Session

* sessionScope: 해당 프로젝트(context)에서 데어터를 주고 받는거 없이 다 사용가능
* 세션도 cookie와 마찬가지로 sessionScope이다. 단, 쿠키와 달리 클라이언트의 특정 위치에 저장되는 것이 아닌 서버상에 객체로써 존재한다.
* 즉, 세션은 서버에서만 접근이 가능하다. 또한 보안이 좋고, 저장할 수 있는 데이터에 한계가 없다.
* 쿠키의 용량은 4KB제한이며, 300개 까지 데이터의 정보를 가질 수 있다.
* Cookie: 사용자의 로컬 PC에 저장되어 읽어 내는것
* Session: 서버에 저장되어 사용되는 것. 브라우저가 종료되면 그대로 소멸한다.
* 웹 프로젝트 내에서 쿠키와 세션은 공통적으로 사용이 가능하다. 단, 발급자가 시간을 정해두었으면 그 시간이 지나면 소멸한다.

### Application Scope

브라우저가 죽어도 살아있는 영역.

### EL, JSTL

* JSTL은 JSP내에서 사용하는 웹 라이브러리로 ```<c:>```형식을 따른다.
* ```<c:set> <c:out> <c:if> <c:choose>``` 등이 있다.
* EL은 JSTL내에서  사용하는 방식으로 변수의 참조나 출력에 사용된다.
* EL의 표기형식은 ```${}```이다.

---
[Go Docs](https://github.com/MristerWing/PrivateProject/tree/master/5.MVC/Docs)
RxJava 공부한것들  
==================
이 프로젝트 내에 있는 코드는 한빛미디어의 RxJava 프로그래밍(저자 유동환, 박정준)을 보며 공부한 코드들입니다.  
  
* 원본 코드 출처: https://github.com/yudong80/reactivejava
* MarbleDiagram 이미지 출처: http://reactivex.io/
  
---

목차
---
0. RxJava
1. chapter01
2. chapter02
3. chapter03
4. chapter04
5. chapter05
6. common

---
RxJava
---
* RxJava의 제네릭 함수형 인터페이스  

| 인터페이스명     | 포함메소드        | 설명                                    |
|------------------|-------------------|-----------------------------------------|
| Predicate< T >   | boolean test(T t) | t 값을 받아서 참이나 거짓을 반환합니다. |
| Consumer < T >   | void accept(T t)  | t 값을 받아서 처리합니다. 반환값 X      |
| Function< T,  R >| R apply(T t)      | t 값을 받아서 결과를 반환합니다.        |

---
chapter01
--------------
기본 적인 선언법과 기초적인 HelloWorld 선언한 코드입니다.

* Link: https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava/src/main/java/com/gmx0807/reactivejava/chapter01

---
chapter02
---
Observable의 기초적인 선언법에 대해 정리했습니다.

* Link: https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava/src/main/java/com/gmx0807/reactivejava/chapter02

---
chapter03
---
reactive의 기초적인 연산자들에 대해서 정리하였습니다.

* Link: https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava/src/main/java/com/gmx0807/reactivejava/chapter03

---
chapter04
---
좀더 응용할 수 있는 reactive연산자들에 대하여 정리 하였습니다.

* Link: https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava/src/main/java/com/gmx0807/reactivejava/chapter04

---
chapter05
---
reactive의 스케줄러 관리에 대하여 정리하였습니다.

* Link: https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava/src/main/java/com/gmx0807/reactivejava/chapter05

---
common
---
전체 프로젝트 내에서 공유해서 사용하는 class들이 작성되어 있는 패키지입니다.

* Link: https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava/src/main/java/com/gmx0807/reactivejava/common

---
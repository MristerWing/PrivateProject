Chapter 01
===
Just
---
![just](./MarbleDiagram/just.c.png)
* Observable의 가장 기본적인 자료구조 함수입니다. just는 인자로 넣는 함수를 차례대로 발행합니다.  
* 인자는 최대 10개까지 구성할 수 있습니다.
* 함수원형(input값마다 매개변수 증가))  
```public static <T> Observable<t> just(T item)```

## Files
### FirstExample.java
* 기초적인 Observable을 선언해보고 RxJava를 맛보기로 해보았습니다. RxJava의 기초적인 구조에 대해 확인했습니다.  
* 또한 가장 기초적인 Observable의 함수인 just()에 대하여 알아보았습니다.

[RxJava메인으로](https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava)
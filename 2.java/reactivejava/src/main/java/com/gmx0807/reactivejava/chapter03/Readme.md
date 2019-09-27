Chapter 03
===
Map
---
![Map](./MarbleDiagram/map.png)
* map()은 어떤 함수에 넣어서 원하는 값으로 변환하는 함수입니다.
* 변환하는 값은 타입이 달라도 가능합니다.(Ex. String -> int)
* map()은 람다식을 이용하여 메소드 참조로 작성합니다.(Ex. map(인자값 -> 반환값))
# 

* 함수원형
<pre><code>@CheckReturnValue
@SchedulerSupport(value = "none")
public final <R> Observable<R> map(Function<? super T,? extends R> mapepr)
</code></pre>

* @CheckReturnValue는 반환값을 확인한다는 의미입니다. 대부분의 연산자에서 함께 사용합니다.
* @SchedulerSupport(value = "none")의 의미는 스케줄러를 지원하지 않는다는 의미입니다. 즉, 현제 스레드에서 실행합니다.



[RxJava메인으로](https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava)
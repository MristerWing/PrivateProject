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

###### 참고 [제너릭 함수형 인터페이스](https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava)

* @CheckReturnValue는 반환값을 확인한다는 의미입니다. 대부분의 연산자에서 함께 사용합니다.
* @SchedulerSupport(value = "none")의 의미는 스케줄러를 지원하지 않는다는 의미입니다. 즉, 현제 스레드에서 실행합니다.

* 파생 함수
    1. flatMap()

## Files
### MapExample.java

---
FlatMap
---
![flatMap](./MarbleDiagram/flatMap.c.png)

* flatMap() 함수는 map()함수를 좀 더 발전시킨 함수입니다.
* map()은 1대1함수이지만 flatMap()은 함수에 값을 넣으면 Observable로 나온다는 것이 다릅니다. 즉, faltMap()은 일대다 함수입니다.

* 함수원형

1.  
<pre><code>@SchedulerSupport(SchedulerSupport.NONE)
public final < R > Observable < R > faltMap (
    Function<? super T, ? extends ObservableSource<? extends R>> mapper)</code></pre>
* SchedulerSupport.NONE은 현제 스레드에서 실행된다는 의미입니다.
* ObservableSource는 chapter02에서 사용한 함수들이 구현되었는 인터페이스입니다. Single을 제외한 대부분의 데이터 발행 함수가 포함됩니다. Single은 SingleSource라는 별도 인터페이스에 구현되어 있습니다.

2.  
<pre><code>@CheckReturnValue
@SchedulerSupport(SchedulerSupport.NONE)
public final < U, R > Observable< R > flatMap (
    Function<? super T, ? extends ObservableSource<? extends U>> mapper, 
        BiFunction<? super T, ? extends R> resultSelector)</code></pre>
* 두번째 인자로 BiFunction<T, U, R> 형태의 resultSelector가 추가된 형태입니다. 
* 첫번째 mapper의 인자로 받은 T와 그것의 결과로 나오는 U를 기반으로 새로운 Observable을 생성하는 방식입니다.

## Files
### FlatMapExample.java
* flatMap()함수의 기본적인 예제에 대해 공부하였습니다.
* flatMap()은 map()과 달리 반환값이 Observable이므로 Observable객체를 생성하여 반환해야 합니다.(ex. faltMap(인자값 -> Observable.just(반환값)))
* 혹은 Function<T, R>인터페이스로 반환 함수를 작성하여 분리하는 방법또한 있습니다.

---
### Gugudan.java
* 비동기식으로 주어진 구구단 예제입니다.

---
Filter
---
![filter](./MarbleDiagram/filter.png)
* filter()는 Observable에서 원하는 데이터만을 걸러내는 역할을 수해합니다.(if)
* filter()는 boolean값을 반환하는 Predicate를 인자로 사용합니다. 이는 진위판별이라는 의미로 boolean값을 리턴하는 특수한 함수형 인터페이스입니다. 코딩시에는 인자를 Function인지 구분할 필요가 없습니다.

## Files
### FilterExample.java
* first(), last(), take(), takeLast(), skip(), skipLast()를 사용해보았습니다.
    1. first(): 함수로 발행되는 데이터중 첫번째 항목만 반환합니다.
    2. last(): 함수로 발행되는 데이터중 마지막 항목만 반환합니다.
    3. take(): 함수로 발행되는 데이터중 원하는 값만큼 가져옵니다.
    4. takeLast(): take()와 동일하나 마지막 값을 기준으로 가져옵니다.
    5. skip(): N개의 항목을 건너띄고 그 다음 데이터들을 가져옵니다.
    6. skipLast(): skip()와 동일하나 마지막 값을 기준으로 가져옵니다.
---
Reduce
---
![Reduce](./MarbleDiagram/reduce.png)
* reduce()함수는 발행한 데이터를 모두 사용하여 어떤 최종결과 데이터로 합성할 때 사용됩니다.
* 함수형 프로그래밍의 가장 기본연산자 패턴인 map/filter/reduce 패턴을 이루는 마지막 필수 함수입니다.
* 상황에 따라 발행된 데이터를 취합하여 새로운 데이터를 발행하는데 주로 사용됩니다.

* 함수원형  
```public final Maybe<T> reduce(BiFunction<T, T, T> reducer)``` 

## Files
### ReduceExample.java

[RxJava메인으로](https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava)
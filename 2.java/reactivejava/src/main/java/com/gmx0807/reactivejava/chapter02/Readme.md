Chapter 02
===
### subject
* subject함수에 대해서 정리되어있는 패키지입니다.
* Link: https://github.com/MristerWing/PrivateProject/tree/master/2.java/reactivejava/src/main/java/com/gmx0807/reactivejava/chapter02/subject

---
Create
---
![create](./MarbleDiagram/create.c.png)
* 데이터를 인자로 넣으면 자동으로 알림 이벤트가 발생하는 just()와 달리 create()함수는 onNext, onComplete, onError와 같은 알림을 개발자가 직접 호출해야 하는 함수입니다.
* 구독자(subscribe())에게 데이터를 발행하기 위해서는 onNext()함수를 호출해야하며, 모든 데이터 발행이 완료되면 반드시 onComplete()함수를 호출해야 합니다.  
* 함수 원형  
<pre><code>Observable<T> create(ObservableOnSubscribe<T> source)
public interface ObservableOnSubscribe<T> {  
    void subscribe(ObservableEmitter<T> e) throws Exception;  
}</code></pre>

## Files
### ObservableCeateExample.java
* 기본적인 create 함수를 사용한 코드 입니다.
* crate함수의 기본흐름인 onNext, onComplete를 사용해 보았습니다.

---
From
---
![create](./MarbleDiagram/from.c.png)
* just()나 create()함수와 달리 다중 데이터를 발행할때 사용합니다.
* 배열이나 컬렉션의 데이터를 처리할때 주로 사용합니다.
* 또한 기존의 객체 or 절차식 프로그래밍에서 사용했던 loop구문으로 사용되기도 합니다.
* 파생되는 함수
    1. fromArray()
    2. fromIterable()
    3. fromCallable()
    4. fromFuture()
    5. fromPubilsher()

## Files
### ObservableFromArray.java
* fraomArray()함수를 사용한 예제입니다.
* 배열이나 컬렉션에 원하는 값을 넣은 후 fromArray()함수를 호출하면 데이터를 차례대로 발행합니다.
* java의 int 타입의 배열은 인식하지 못하기 때문에 Integer로 변환해야 합니다.
---
### ObservableFromIterable.java

---
### ObservableFromCallable.java

---
### OservableFormFuture.java

---
### ObservalbeFormPulisher.java

---
ConnectableObservalbeExample.java
---

---
ObservalbeNotifications.java
---

---
SingleExample.java
---

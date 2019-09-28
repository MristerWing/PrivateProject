RxAndroid 
===

### 안드로이드에서 사용할 수 있는 리액티브 API및 라이브러리 목록  

| 리엑티브 API             | 설명                                                                                              |
|--------------------------|---------------------------------------------------------------------------------------------------|
| RxLifecycle              | RxJava를 사용하는 안드로이드 앱용 라이프 사이클 처리 API. Trello 제작                             |
| RxBinding                | 안드로이드 UI위젯용 RxJava 바인딩 API                                                             |
| SqlBrite                 | SQLITEOpenHelper와 ContentResilver 클래스의 래퍼(wrapper)클래스로 쿼리에 리액티브 스트림을 도입함 |
| Android-ReactiveLocation | 안드로이드용 리액티브 위치 API라이브러리(RxJava 1.x 기준)                                         |
| RxLocation               | 안드로이드용 리액티브 위치 API라이브러리(RxJava 2,x 기준)                                         |
| rx-preferences           | 안드로이드용 리액티브 SharedPreferences 인터페이스                                                |
| RxFit                    | 안드로이드용 리액티브 Fit 라이브러리                                                              |
| RxWear                   | 안드로이드용 리액티브 웨어러블 API 라이브러리                                                     |
| RxPermissions            | RxJava에서 제공하는 안드로이드 런터임 권한 라이브러리                                             |
| RxNotifcation            | RxJava로 알림(notification)을 관리하는 API                                                        |
| RxClipboard              | 안드로이드 클립 보드용 RxJava 바인딩 API                                                          |
| RxBroadcast              | 안드로이드용 Broadcast 및 LocalBroadcast에 관한 RxJava 바인딩 API                                 |
| RxAndroidBle             | 블루투스 LE(Bluetooth Low Energy)장치를 다루기 위한 리액티브 라이브러리                           |
| RxImagePicker            | 갤러리 또는 카메라에서 이미지를 선택하기 위한 리액티브 라이브러리                                 |                                                 
| ReactiveNetwork | 네트워크 연결 상태나 인터넷 연결 상태를 확인하는 리액티브 라이브러리(RxJava 1.x 및 RxJava 2.x 호환) |   
| ReactiveBeacons | 주변에 있는 블루투스 Le 기반의 비컨을 수신하는 리액티브 라이브러리(RxJava 1.x 및 RxJava 2.x 호환) |
| RxDataBinding   | 안드로이드 데이터 바인딩 라이브러리용 RxJava2 바인딩 API           |

---
### RxAndroid 기본 구성
* Observable: 비즈니스 로직을 이용해 데이터를 발행
* subscribe: Observable에서 발행한 데이터를 구독
* 스케줄러: 스줄러를 통해서 Observable. 구독자가 어느 스레드에서 실행될지 결정.

---
### RxAndroid에서 제공하는 스케줄러
| 스케줄러 이름                  | 설명                                       |
|--------------------------------|--------------------------------------------|
| AndroidSchedulers.mainThread() | 안드로이드 UI 스레드에서 동작하는 스케줄러 |
| HandlerScheduler.from(handler) | 특정 핸드러에 의존하여 동작하는 스케줄러   |

